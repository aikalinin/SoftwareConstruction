package org.edu.hse.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Drawable {

    default void draw() {
        System.out.println("Hello from drawable draw");
    }

    default void defaultMethod() {
        System.out.println("Hi from the default method");
    }

    default String printSelf() {
        System.out.println("Hi from printSelf (Drawable)");
        return "Drawable Hi";
    }

    default void sayHello() {
        System.out.println("Hello!");
    }

    static void staticMethod() {
        System.out.println("Hi");
    }

    void notDefault();
}
