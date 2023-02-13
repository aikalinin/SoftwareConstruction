package org.edu.hse.seminar10.concurrency.race.condition;

import java.util.stream.IntStream;

public class RaceConditionMain {

    public static void main(String[] args) {
        System.out.println(DumbCounter.class.getName());

        for (int i = 0; i < 100; ++i) {
            DumbCounter counter = new DumbCounter();
            IntStream.range(0, 1000000).parallel().forEach(counter::increment);
            System.out.println(counter.getCount());
        }

        System.out.println(AtomicDumbCounter.class.getName());

        for (int i = 0; i < 100; ++i) {
            AtomicDumbCounter counter = new AtomicDumbCounter();
            IntStream.range(0, 1000000).parallel().forEach(counter::increment);
            System.out.println(counter.getCount().get());
        }
    }
}
