package org.edu.hse.interfaces;

public class Implementer extends AbstractPrinter implements Drawable, Printable {

    @Override
    public void sayHello() {
//        1+1;
        Drawable.super.sayHello();
    }

    @Override
    public void notDefault() {

    }

    @Override
    public void draw() {
        super.draw();
        Drawable.super.draw();
    }


    @Override
    public String printSelf() {
        Printable.super.printSelf();
        return Drawable.super.printSelf();
    }

/*    @Override
    public String printSelf() {
        return Drawable.super.printSelf() + Printable.super.printSelf();
    }*/

}
