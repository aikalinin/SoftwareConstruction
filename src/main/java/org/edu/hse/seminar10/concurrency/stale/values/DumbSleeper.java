package org.edu.hse.seminar10.concurrency.stale.values;

import lombok.SneakyThrows;

class DumbSleeper implements Runnable {
    private volatile Boolean asleep;

    public DumbSleeper(Boolean asleep) {
        this.asleep = asleep;
    }

    public void setAsleep(Boolean asleep) {
        this.asleep = asleep;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!asleep) {
            //countSomeSheep
            //УСНЁМ ЛИ МЫ?
//            Thread.sleep(500);
            System.out.println("Work");
        }
    }
}