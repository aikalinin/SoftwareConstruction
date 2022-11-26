package org.edu.hse.exceptions;

public class WastedException extends RuntimeException {

    public WastedException(int age) {
        super(String.format("You've become too old and died at the agr of %s", age));
    }

    public WastedException(String message) {
        super(message);
        System.out.println("You died!!!");
    }
}
