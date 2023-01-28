package org.edu.hse.seminar9.memento;

import org.edu.hse.seminar9.memento.caretaker.Caretaker;
import org.edu.hse.seminar9.memento.caretaker.PlayerCaretaker;
import org.edu.hse.seminar9.memento.model.Player;
import org.edu.hse.seminar9.memento.originator.Originator;
import org.edu.hse.seminar9.memento.originator.PlayerOriginator;

public class MementoMain {
    public static void main(String[] args) {
        final Originator<Player> originator = new PlayerOriginator();
        final Caretaker<Player> careTaker = new PlayerCaretaker();

        originator.setState(Player.builder()
                .currentGame("Tetris")
                .name("Vasya")
                .rating(120)
                .build());

        originator.setState(Player.builder()
                .currentGame("Tetris")
                .name("New Vasya")
                .rating(120)
                .build());
        careTaker.add(originator.saveStateToMemento());

        originator.setState(Player.builder()
                .currentGame("Tetris")
                .name("New Vasya")
                .rating(1000)
                .build());
        careTaker.add(originator.saveStateToMemento());


        originator.setState(Player.builder()
                .currentGame("Tetris 2077")
                .name("New Vasya")
                .rating(120)
                .build());
        System.out.println("Current state from originator: " + originator.getState());

        originator.loadStateFromMemento(careTaker.getLast());
        System.out.println("Last saved state in originator: " + originator.getState());

        System.out.println("All states in Caretaker: " + careTaker.getAll().stream()
                .map(Object::toString)
                .reduce(" ",
                        (a, e) -> a + " " + e));
    }
}
