package org.edu.hse.seminar9.memento.caretaker;

import org.edu.hse.seminar9.memento.Memento;

import java.util.List;

public interface Caretaker<T> {
    void add(Memento<T> mementoState);

    Memento<T> get(int index);

    Memento<T> getLast();

    List<Memento<T>> getAll();
}
