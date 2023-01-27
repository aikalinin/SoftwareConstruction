package org.edu.hse.inner;

import org.edu.hse.lambda.Functional;
import org.edu.hse.lambda.Handler;

public class OuterClass {

    public class InnerClass {
        public void printThing(int localVariable) {
            System.out.printf("%s class print %d\n", this.getClass().getName(), OuterClass.this.localVariable);
        }
    }

    /*
        Вложенный класс из C++
     */
    public static class StaticInnerClass {

        final OuterClass outerRef;

        public StaticInnerClass() {
            this.outerRef = new OuterClass();
        }

        public StaticInnerClass(OuterClass outerRef) {
            this.outerRef = outerRef;
        }

        public void printThing(int localVariable) {
            System.out.printf("%s class print %d\n", this.getClass().getName(), outerRef.localVariable);
        }
    }

    private final int localVariable = 42;

    public OuterClass() {
        start();
        containsInnerClass();
    }

    static String field;

    void start() {
        var inner = new InnerClass();
        inner.printThing(52);
        System.out.println("Outer class print");

        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        new OuterClass.StaticInnerClass();

        var staticInner = new StaticInnerClass(this);
        staticInner.printThing(33);
    }


    void containsInnerClass() {
        class MethodInnerClass {
            public void printThing(int localVariable) {
                System.out.printf("%s class print %d\n", this.getClass().getName(), OuterClass.this.localVariable);
            }
        }

        var localInnerClass = this.new InnerClass();
        localInnerClass.printThing(33);
    }

    void anonInnerClass() {
        Handler localInnerClass = new Handler() {
            @Override
            public int handle() {
                System.out.printf("%s class print %d\n", this.getClass().getName(), OuterClass.this.localVariable);
                return 1;
            }
        };
        localInnerClass.handle();
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
