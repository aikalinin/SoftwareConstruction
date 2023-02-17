package org.edu.hse.seminar11.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainExecutorService {

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        final ExecutorService executorService =
                new ThreadPoolExecutor(
                        1,
                        10,
                        0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());


        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        executorService.execute(runnableTask);

        try {
            String result = executorService.invokeAny(callableTasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
