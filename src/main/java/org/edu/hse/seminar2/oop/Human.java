package org.edu.hse.seminar2.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Human {

    private String name;

    private LocalDate birthDate;

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

    public abstract void speak(String text);

    public abstract void walk(Double meters);

    public abstract void eat(String[] food);

    public abstract int getAge();

    public Human(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("My name is %s\nI was born in %s, I'm %d years old.",
                name,
                dateTimeFormatter.format(birthDate),
                getAge());
    }
}
