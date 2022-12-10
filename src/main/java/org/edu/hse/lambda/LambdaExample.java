package org.edu.hse.lambda;

import java.util.*;

public class LambdaExample {

    public static final Map<String, Handler> map = new HashMap<>();

    public List<Integer> values = new ArrayList<>() {{ add(10); add(20);}};


    /*
      Создание обработчика флагов
     */
    static {
        map.put("/r", () -> {
            System.out.println("R");
            return 0;
        });
        map.put("/d", () -> {
            System.out.println("D");
            return 0;
        });
        map.put("/p", () -> {
            System.out.println("out");
            return 1;
        });
    }

    public LambdaExample() {
        lambdaMethod(value -> 42);
    }

    static void lambdaMethod(Functional<String, Integer> f) {
        f.run("hiii");
    }
}
