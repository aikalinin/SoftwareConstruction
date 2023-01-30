package org.edu.hse.seminar9.memento.originator;

import lombok.ToString;
import org.edu.hse.seminar9.memento.Memento;
import org.edu.hse.seminar9.memento.model.Player;

@ToString
public class PlayerOriginator implements Originator<Player> {

    private Player state;

    @Override
    public Player getState() {
        return state;
    }

    @Override
    public void setState(Player state) {
        this.state = state;
    }

    @Override
    public Memento<Player> saveStateToMemento() {
        return new Memento<>(state);
    }

    @Override
    public void loadStateFromMemento(Memento<Player> memento) {
        this.state = memento.getState();
    }
}
