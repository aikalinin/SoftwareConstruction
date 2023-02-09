package org.edu.hse.seminar10.concurrency.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("This is " + this.getClass().getSimpleName());
        System.out.println("Hello from " + Thread.currentThread().getName());
        badMethod();
    }

    private void badMethod() {
        throw new RuntimeException("Bad execution");
    }
}
