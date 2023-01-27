package org.edu.hse.seminar9.observer.dependences.subject;

import org.edu.hse.seminar9.observer.dependences.Observer;

public interface Subject<T> {

    T getState();

    void setState(T state);

    void attach(String name, Observer<T> observer);

    void notifyAllObservers();

    void notifyObserver(String observerName);
}
