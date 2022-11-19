package org.edu.hse.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Drawable {

    default void draw() {
        System.out.println("Hello from drawable draw");
    }

    default String printSelf() {
        throw new RuntimeException("Implement logic");
    }

    default void sayHello() {
        System.out.println("Hello!");
    }
}
