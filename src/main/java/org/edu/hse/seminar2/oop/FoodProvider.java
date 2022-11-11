package org.edu.hse.seminar2.oop;

import java.util.List;

public class FoodProvider {
    public static String MakeCoffee(List<String> additives) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Coffee with ");
        additives.forEach(item -> stringBuilder.append(item).append(" and "));
        stringBuilder.append("java");

        return stringBuilder.toString();
    }

    public static String MakeBurger(List<String> additives) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nBurger:\n");
        additives.forEach(item -> stringBuilder.append(item).append("\n"));

        return stringBuilder.toString();
    }
}
