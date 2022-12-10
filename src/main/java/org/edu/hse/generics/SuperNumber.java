package org.edu.hse.generics;

import java.util.*;


public class SuperNumber<T> implements Summable<Number> {

    private T type;
    private final Number t;


    public SuperNumber(Number t) {
        this.t = t;
    }

    public Optional<Integer> optionalNullMethod(Optional<Integer> i) {
        Optional.empty();
        Optional.of(190);
        Optional.ofNullable(i);
        i.isEmpty();
        Integer nonNull = i.orElse(0);
        return Optional.empty();
    }

    public List<Integer> nullMethod(Integer i) {

        if (i != null && i.doubleValue() > 10)
            return new ArrayList<>();

        return new ArrayList<>();
    }


    public static void reverse(List<? extends Number> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size()-i-1));
        }
    }

    public static<T extends Number> T add(T x, T y){
        Double sum;
        sum = x.doubleValue() + y.doubleValue();
        return (T) sum;
    }

    @Override
    public Number add(Number other) {
        return this.t.doubleValue() + other.doubleValue();
    }
}
