package org.edu.hse.seminar2;

import org.edu.hse.seminar2.oop.Worker;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("Igor", LocalDate.of(2004, 9, 11));

        worker.eat(new String[]{"Meal", "Noodles"});
        System.out.println(worker.getAge());
    }
}