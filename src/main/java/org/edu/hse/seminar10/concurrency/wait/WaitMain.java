package org.edu.hse.seminar10.concurrency.wait;

import org.edu.hse.seminar9.memento.model.Player;

public class WaitMain {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();

        Player player = Player.builder()
                .name("a")
                .currentGame("b")
                .rating(1)
                .build();

        threadA.setPlayer(player);
        threadA.start();

        synchronized (player) {
//          player.lock();
            player.wait();
//          player.unlock();
        }

//        threadA.join();

        System.out.println(threadA.getTotal());
    }
}