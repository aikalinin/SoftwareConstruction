package org.edu.hse.generics;

public interface Summable<T> extends Summable<Summable<Number>> {
    T add(T other);
}
