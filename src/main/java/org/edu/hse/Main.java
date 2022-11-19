package org.edu.hse;

import org.edu.hse.interfaces.Drawable;
import org.edu.hse.interfaces.Implementer;
import org.edu.hse.interfaces.Printable;

public class Main {

    public static void main(String[] args) {
        Implementer implementer = new Implementer();

        implementer.sayHello();
        implementer.draw();
        implementer.printSelf();

    }
}