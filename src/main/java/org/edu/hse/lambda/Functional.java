package org.edu.hse.lambda;

@FunctionalInterface
public interface Functional<T, E> {
    E run(T value);

//    T run2();
}
