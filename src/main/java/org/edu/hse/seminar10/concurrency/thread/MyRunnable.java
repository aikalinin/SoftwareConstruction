package org.edu.hse.seminar10.concurrency.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
