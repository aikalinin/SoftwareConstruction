package org.edu.hse.lambda;

import java.util.*;

public class LambdaExample {

    public static final Map<String, Handler> map = new HashMap<>();

    public List<Integer> values = new ArrayList<>() {{
            add(10);
            add(20);
        }};

    {
        values.add(23);
        values.add(23);
    }

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

        String input = "/r";
        map.get(input).handle();
    }

    public LambdaExample() {
        lambdaMethod((value) -> value.length());
        lambdaMethod(String::length);
    }

    static void lambdaMethod(Functional<String, Integer> callback) {
        // ...
        Integer i = callback.run("hi");
        System.out.println(i);
    }
}
