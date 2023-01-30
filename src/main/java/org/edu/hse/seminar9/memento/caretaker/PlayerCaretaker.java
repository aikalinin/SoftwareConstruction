package org.edu.hse.seminar9.memento.caretaker;

import org.edu.hse.seminar9.memento.Memento;
import org.edu.hse.seminar9.memento.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCaretaker implements Caretaker<Player> {

    private final List<Memento<Player>> mementoList = new ArrayList<>();

    public void add(Memento<Player> mementoState) {
        mementoList.add(mementoState);
    }

    public Memento<Player> get(int index) {
        return mementoList.get(index);
    }

    public Memento<Player> getLast() {
        return mementoList.get(mementoList.size() - 1);
    }

    public List<Memento<Player>> getAll() {
        return mementoList;
    }
}
