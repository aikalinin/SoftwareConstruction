package org.edu.hse.oop;

import org.edu.hse.exceptions.CrampedLegException;
import org.edu.hse.exceptions.WastedException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Human {

    private String name;

    private LocalDate birthDate;

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern("dd LLLL yyyy")
            .withLocale(Locale.ENGLISH);

    public abstract void speak(String text);

    public abstract void walk(Integer meters) throws CrampedLegException;

    public abstract void eat(String[] food);

    public abstract int getAge() throws WastedException;

    public Human(String name, LocalDate birthDate) {
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
        try {
            return String.format("My name is %s\nI was born in %s, I'm %d years old.",
                    name,
                    dateTimeFormatter.format(birthDate),
                    getAge());
        } catch (WastedException e) {
            return e.getMessage();
        }
    }
}
