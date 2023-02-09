package org.edu.hse.seminar10.concurrency.reordering;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

public class SyncSymbol {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; ++i) {
            final SymbolHandler handler = new SymbolHandler();

            final SymbolThread myThread1 = new SymbolThread() {
                @Override
                public void run() {
                    getResource().updateA();
                }
            };
            final SymbolThread myThread2 = new SymbolThread() {
                @Override
                public void run() {
                    getResource().updateB();
                }
            };

            myThread1.setName("MyThread1");
            myThread2.setName("MyThread2");

            myThread1.setResource(handler);
            myThread2.setResource(handler);

            myThread1.start();
            myThread2.start();

            myThread1.join();
            myThread2.join();

            System.out.println(MessageFormat.format(
                    "{0} {1} {2} {3}",
                    handler.getA(),
                    handler.getB(),
                    handler.getX(),
                    handler.getY()
                    ));
        }
    }
}

@Setter
@Getter
class SymbolThread extends Thread {
    private Handler resource;
}

interface Handler {

    void updateA();

    void updateB();
}

@Getter
@Setter
class SymbolHandler implements Handler {
    private int a;

    private int b;

    private int x;

    private int y;

    // 1 1 1 1 - a = 1 -> b = 1 -> a = b -> y = a -> x = b (один из возможных случаев)
    // 0 1 1 0 - a = 1 -> a = b -> b = 1 -> x -> x = b -> y = a (один из возможных случаев)

    // Ideal: 0 1 0 0
    @Override
    public void updateA() {
        a = 1;
        if (Thread.currentThread().getName().equals("MyThread1")) {
            Thread.yield();
        }
        a = b;
        if (Thread.currentThread().getName().equals("MyThread1")) {
            Thread.yield();
        }
        x = b;
    }

    // Ideal: 1 1 1 0
    @Override
    public void updateB() {
        b = 1;
        if (Thread.currentThread().getName().equals("MyThread1")) {
            Thread.yield();
        }
        y = a;
    }
}

@Getter
@Setter
class SyncSymbolHandler implements Handler {
    private int a;

    private int b;

    private int x;

    private int y;

    @Override
    public synchronized void updateA() {
        a = 1;

        if (Thread.currentThread().getName().equals("MyThread1")) {
            Thread.yield();
        }

        x = b;
    }

    @Override
    public void updateB() {
        synchronized (this) {
            b = 1;
            if (Thread.currentThread().getName().equals("MyThread1")) {
                Thread.yield();
            }

            y = a;
        }
    }
}
