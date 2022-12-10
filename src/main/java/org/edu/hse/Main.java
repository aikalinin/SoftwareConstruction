package org.edu.hse;

import org.edu.hse.generics.SuperNumber;
import org.edu.hse.inner.OuterClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        var outer = new OuterClass();
        outer.new InnerClass();

        new OuterClass().new InnerClass();

        new OuterClass.StaticInnerClass(outer);
    }
}