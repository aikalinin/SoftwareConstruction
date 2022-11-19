package org.edu.hse.interfaces;

import java.io.Serializable;

public abstract class AbstractPrinter implements Serializable, Cloneable {

    public void draw() {
        System.out.println("Hello from abstract painter");
    }

    @Override
    public AbstractPrinter clone() {
        try {
            return (AbstractPrinter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
