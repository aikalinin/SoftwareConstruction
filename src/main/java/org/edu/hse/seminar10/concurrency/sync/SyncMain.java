package org.edu.hse.seminar10.concurrency.sync;

import lombok.Getter;
import lombok.Setter;

public class SyncMain {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 100; ++i) {
            final Resource serverResource = new SyncServerResource();
            serverResource.setI(10);

            final MyThread myThread1 = new MyThread();
            final MyThread myThread2 = new MyThread();

            myThread1.setName("MyThread1");

            myThread1.setResource(serverResource);
            myThread2.setResource(serverResource);

            myThread1.start();
            myThread2.start();

            myThread1.join();
            myThread2.join();

            System.out.println(serverResource.getI());
        }
    }
}

@Setter
class MyThread extends Thread {
    private Resource resource;

    @Override
    public void run() {
        resource.update();
    }
}

interface Resource {

    void setI(int i);

    int getI();
    void update();
}

@Getter
@Setter
class ServerResource implements Resource {
    private int i;

    public void update() {
        int i = this.i;
        if (Thread.currentThread().getName().equals("MyThread1")) {
            Thread.yield();
        }
        i++;
        this.i = i;
    }
}

@Getter
@Setter
class SyncServerResource implements Resource {
    private int i;

    public void update() {
        synchronized (this) {
            int i = this.i;
            if (Thread.currentThread().getName().equals("MyThread1")) {
                Thread.yield();
            }
            i++;
            this.i = i;
        }
    }
}
