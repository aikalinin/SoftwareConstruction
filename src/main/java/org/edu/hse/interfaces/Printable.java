package org.edu.hse.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Printable {

    default String printSelf() {
        throw new RuntimeException("Implement logic");
    }

    void sayHello();
}
