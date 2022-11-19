package org.edu.hse;

import org.edu.hse.oop.FoodProvider;
import org.edu.hse.oop.TestProvider;
import org.edu.hse.oop.Testable;
import org.edu.hse.oop.Worker;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("Igor", LocalDate.of(2004, 9, 11));

        final String coffee = FoodProvider.makeCoffee(Arrays.asList("milk", "sugar"));
        final String burger = FoodProvider.makeBurger(Arrays.asList("bun", "cheese", "tomato", "steak", "pickles", "bun"));

        worker.eat(new String[]{coffee, "Noodles", burger});
        System.out.println(worker.getAge());

        Worker.printWorkersCount();

        worker.addScore(10);
        worker.addScore(5);

        Testable testable = new Worker("Alex",LocalDate.of(2004, 9, 11));
        testable.addScore(9);

        System.out.println(TestProvider.calculateAverageScore(Arrays.asList(worker, testable)));
        System.out.println(worker);
    }
}