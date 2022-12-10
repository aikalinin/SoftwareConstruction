package org.edu.hse.lambda;

import jdk.jshell.spi.ExecutionControl;

public interface Handler {
    int handle();

    default void defaultHandle() {
        throw new IllegalStateException();
    };
}
