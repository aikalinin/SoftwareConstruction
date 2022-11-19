package org.edu.hse.interfaces;

import jdk.jshell.spi.ExecutionControl;

public class Implementer extends AbstractPrinter implements Drawable, Printable {

    @Override
    public String printSelf() {
        return Drawable.super.printSelf() + Printable.super.printSelf();
    }

    @Override
    public void sayHello() {
        Drawable.super.sayHello();
    }

    /*@Override
    public void draw() {

    }*/
}
