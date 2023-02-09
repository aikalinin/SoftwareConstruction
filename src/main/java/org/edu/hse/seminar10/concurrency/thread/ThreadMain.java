package org.edu.hse.seminar10.concurrency.thread;

import java.text.MessageFormat;

public class ThreadMain {

    public static void main(String[] args) {
        final MyThread myThread = new MyThread();
        myThread.start();

        final Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

        System.out.println("Thread in Main is " + Thread.currentThread().getName());

        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println(MessageFormat.format(
                        "[{0}] {1}",
                        Thread.currentThread().getName(),
                        i
                ));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                System.out.println(MessageFormat.format(
                        "[{0}] {1}",
                        Thread.currentThread().getName(),
                        i
                ));
            }
        }).start();

        try {
            runnableThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
