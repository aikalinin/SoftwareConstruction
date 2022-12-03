package org.edu.hse.generics;

import java.util.ArrayList;

public class SuperNumber implements Summable<Number> {

    private final Number t;

    public SuperNumber(Number t) {
        this.t = t;
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
