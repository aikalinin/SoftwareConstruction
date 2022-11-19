package org.edu.hse.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Printable {

    default void myMethod() {
        System.out.println("Hi");
    }

    default String printSelf() {
        System.out.println("Hi from printSelf (Printable)");
        return "Printable Hi";
    }

    void sayHello();
}
