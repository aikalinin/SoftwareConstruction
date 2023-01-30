package org.edu.hse.seminar9.memento.originator;

import org.edu.hse.seminar9.memento.Memento;

public interface Originator<T> {

    T getState();

    void setState(T state);

    Memento<T> saveStateToMemento();

    void loadStateFromMemento(Memento<T> memento);
}
