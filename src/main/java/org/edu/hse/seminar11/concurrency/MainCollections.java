package org.edu.hse.seminar11.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class MainCollections {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    private static final List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();
    private static final List<Integer> regularList = new ArrayList<>();

    public static void main(String[] args) {

        IntStream.range(MIN_VALUE, MAX_VALUE).forEach(i -> {
            copyOnWriteList.add(i);
            regularList.add(i);
        });

        var copyIterator = copyOnWriteList.iterator();
//        var regularIterator = regularList.iterator();

        copyOnWriteList.add(20);
//        regularList.add(20);

        while (copyIterator.hasNext()) {
            var el = copyIterator.next();
            System.out.println(el);
        }

//        while (regularIterator.hasNext()) {
//            var el = regularIterator.next();
//            System.out.println(el);
//        }

//        var changeThread = new Thread(() -> {
//            for(int i = MIN_VALUE; i < MAX_VALUE; ++i) {
//                regularList.set(i, regularList.get(i) * 2);
//            }
//        });
//
//        var readThread = new Thread(() -> {
//            for(int i = MIN_VALUE; i < MAX_VALUE; ++i) {
//                System.out.println(regularList.get(i));
//            }
//        });
//
//        changeThread.start();
//        readThread.start();
    }
}
