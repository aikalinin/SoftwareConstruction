package org.edu.hse.seminar2;

import org.edu.hse.seminar2.oop.FoodProvider;
import org.edu.hse.seminar2.oop.Student;
import org.edu.hse.seminar2.oop.Worker;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("Igor", LocalDate.of(2004, 9, 11));

        final String coffee = FoodProvider.MakeCoffee(Arrays.asList("milk", "sugar"));
        final String burger = FoodProvider.MakeBurger(Arrays.asList("bun", "cheese", "tomato", "steak", "pickles", "bun"));

        worker.eat(new String[]{coffee, "Noodles", burger});
        System.out.println(worker.getAge());

        Worker.printWorkersCount();
    }
}