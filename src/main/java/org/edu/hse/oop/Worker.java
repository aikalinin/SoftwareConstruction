package org.edu.hse.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Наследование
public class Worker extends Human implements Testable {

    // Encapsulation
    private final List<Integer> scores = new ArrayList<>();

    private String position;

    private static Integer count;

    // Про статикку
    static {
        count = 0;
    }

    public Worker(String name, LocalDate birthDate) {
        // super(name, birthDate);
        this(name, birthDate, "junior");
    }

    public Worker(String name, LocalDate birthDate, String position) {
        super(name, birthDate);
        this.position = position;
        count += 1;
    }

    public static void printWorkersCount() {
        System.out.println(count);
    }

    @Override
    public void speak(String text) {
        System.out.println("Worker is saying" + text);
    }

    @Override
    public void walk(Double meters) {
        System.out.printf("Worker has run %f mitres\n", meters);
    }

    @Override
    public void eat(String[] food) {
        String message = Arrays.stream(food).reduce((acc, next) -> acc + ", " + next).orElse("Nothing");
        System.out.println("Worker ate: " + message);
    }

    // Polymorphism
    @Override
    public int getAge() {
        return LocalDate.now().getYear() - getBirthDate().getYear();
    }

    public int getAge(LocalDate from) {
        return from.getYear() - getBirthDate().getYear();
    }

    @Override
    public void addScore(Integer score) {
        scores.add(score);
    }

    @Override
    public List<Integer> getScores() {
        return scores;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
