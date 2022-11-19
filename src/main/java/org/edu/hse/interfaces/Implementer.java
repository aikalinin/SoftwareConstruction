package org.edu.hse.interfaces;

public class Implementer extends AbstractPrinter implements Drawable, Printable {

    @Override
    public void sayHello() {
        Drawable.super.sayHello();
    }

    @Override
    public void draw() {
        Drawable.super.draw();
    }

    @Override
    public String printSelf() {
        return Drawable.super.printSelf() + Printable.super.printSelf();
    }
}
