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
        threadA.player = player;
        threadA.start();

        synchronized (player) {
            player.wait();
        }

        System.out.println(threadA.total);
    }

    static class ThreadA extends Thread {
        int total;

        Player player;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.notify();
            }
        }
    }
}