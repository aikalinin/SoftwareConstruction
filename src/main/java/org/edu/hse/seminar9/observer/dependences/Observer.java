package org.edu.hse.seminar9.observer.dependences;

import org.edu.hse.seminar9.observer.dependences.subject.Subject;

public abstract class Observer<T> {
    protected Subject<T> subject;

    public abstract void update();
}
