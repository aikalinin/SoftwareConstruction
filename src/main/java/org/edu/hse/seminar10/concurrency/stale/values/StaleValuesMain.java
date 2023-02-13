package org.edu.hse.seminar10.concurrency.stale.values;

import lombok.SneakyThrows;

public class StaleValuesMain {

    @SneakyThrows
    public static void main(String[] args) {
        final DumbSleeper dumbSleeper = new DumbSleeper(false);

        final Thread thread = new Thread(dumbSleeper);
        thread.start();

        dumbSleeper.setAsleep(true);
        dumbSleeper.setAsleep(false);
//        dumbSleeper.setAsleep(true);

//        Thread.sleep(1000);

        thread.join();
    }
}
