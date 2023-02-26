package org.edu.hse.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Human {

    private String name;

    private LocalDate birthDate;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern("dd LLLL yyyy")
            .withLocale(Locale.ENGLISH);

    public abstract void speak(String text);

    public abstract void walk(Double meters);

    public abstract void eat(String[] food);

    public abstract int getAge();

    protected Human(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public final String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public final void setName(String name) {
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
