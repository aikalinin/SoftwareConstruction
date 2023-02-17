package org.edu.hse.seminar11.concurrency;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MainBlockingQueue {

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            var executorService = new ThreadPoolExecutor(
                    2,
                    2,
                    0L,
                    TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(1));

            Executors.newCachedThreadPool();

            List<Callable<Integer>> tasks = Arrays.asList(
                    () -> {
                        Thread.sleep(1000);
                        return 1;
                    },
                    () -> {
                        Thread.sleep(1000);
                        return 2;
                    }
            );

            final Integer result = executorService.invokeAny(tasks);

            Future<Integer> thirdsFuture = executorService.submit(() -> {
                Thread.sleep(1000);
                return 3;
            });

            try {
                System.out.println(result);
                System.out.println(thirdsFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            } finally {
                executorService.shutdown();
            }
        }

    }
}
