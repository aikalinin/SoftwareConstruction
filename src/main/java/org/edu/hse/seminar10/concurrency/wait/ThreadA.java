package org.edu.hse.seminar10.concurrency.wait;

import lombok.Getter;
import lombok.Setter;
import org.edu.hse.seminar9.memento.model.Player;

@Getter
@Setter
class ThreadA extends Thread {
    private int total;

    private Player player;

    @Override
    public void run() {
        synchronized (player) {
            for (int i = 0; i < 5; i++) {
                total += i;
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            player.notify();
        }

        System.out.println(Thread.currentThread().getName() + " thread was terminated");
    }
}
