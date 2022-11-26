package org.edu.hse.exceptions;

public class CrampedLegException extends Exception {

    public CrampedLegException(int meters) {
        super(String.format("After %s meters your leg got cramped", meters));
    }
}
