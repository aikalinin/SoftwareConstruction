package org.edu.hse.seminar9.observer.dependences.subject;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.edu.hse.seminar9.observer.dependences.Observer;
import org.edu.hse.seminar9.observer.dependences.model.Profile;

import java.util.Map;
import java.util.WeakHashMap;

@RequiredArgsConstructor
public class DefaultSubject implements Subject<Profile> {

    private final Map<String, Observer<Profile>> observers = new WeakHashMap<>();

    private Profile state;

    @Override
    public Profile getState() {
        return state;
    }

    @Override
    public void setState(Profile state) {
        this.state = state;
        notifyAllObservers();
    }

    @Override
    public void attach(String name, Observer<Profile> observer) {
        observers.put(name, observer);
    }

    @Override
    public void notifyAllObservers() {
        observers.values().forEach(Observer::update);
    }

    @Override
    public void notifyObserver(String observerName) {
        final Observer<Profile> observer = observers.get(observerName);

        if (observer != null) {
            observer.update();
        }
    }

    @UtilityClass
    public class ObserverNames {

        public static final String DATE_LABEL_OBSERVER = "DATE_LABEL_OBSERVER";

        public static final String PROFILE_ICON_OBSERVER = "PROFILE_ICON_OBSERVER";
    }
}
