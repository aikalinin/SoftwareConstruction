package org.edu.hse.oop;

import org.edu.hse.exceptions.CrampedLegException;
import org.edu.hse.exceptions.WastedException;
import org.edu.hse.interfaces.Testable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Наследование
public class Worker extends Human implements Testable {

    static final Random random = new Random();
    // Encapsulation
    private final List<Integer> scores = new ArrayList<>();

    public Worker(String name, LocalDate birthDate) {
         super(name, birthDate);
    }

    @Override
    public void speak(String text) {
        System.out.println("Worker is saying" + text);
    }

    @Override
    public void walk(Integer meters) throws CrampedLegException {

        if (random.nextInt(100) > 30) {
            throw new CrampedLegException(meters);
        }

        System.out.printf("Worker has run %d mitres\n", meters);
    }

    @Override
    public void eat(String[] food) {
        String message = Arrays.stream(food).reduce((acc, next) -> acc + ", " + next).orElse("Nothing");
        System.out.println("Worker ate: " + message);
    }

    @Override
    public int getAge() {
        int age = random.nextInt(400);
        if (age > 100) {
            throw new WastedException(age);
        }

        return LocalDate.now().getYear() - getBirthDate().getYear();
    }

    @Override
    public void addScore(Integer score) {
        scores.add(score);
    }

    @Override
    public List<Integer> getScores() {
        return scores;
    }
}
