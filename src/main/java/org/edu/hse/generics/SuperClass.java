package org.edu.hse.generics;

import java.util.ArrayList;

public class SuperClass<T> extends NutSuperClass {
    T t;

    public SuperClass(T t) {
        super(t.toString());
        this.t = t;
    }
}
