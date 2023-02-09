package org.edu.hse.seminar10.concurrency.race.condition;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class AtomicDumbCounter {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment(int v) {
        count.incrementAndGet();
    }
}
