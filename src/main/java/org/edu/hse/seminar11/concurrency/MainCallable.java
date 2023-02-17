package org.edu.hse.seminar11.concurrency;

import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.concurrent.*;

public class MainCallable {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
//        threadWithException();
//        runnableWithException();
        callableWithException();
    }

    public static class FactorialCallableTask implements Callable<Integer> {
        int number;

        public FactorialCallableTask(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws InvalidParameterException {
            for (int i = 0; i < 10000; i++) { }

            if (number < 0) {
                throw new InvalidParameterException("Number should be positive");
            }

            return 0;
        }
    }

    private static void threadWithException() {
        var exceptionThread = new Thread(() -> {
            throw new RuntimeException("Exception in Thread" + Thread.currentThread().getName());
        });

        try {
            exceptionThread.start();
            exceptionThread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void runnableWithException() {
        Future<?> futureRunnable = executorService.submit((Runnable) () -> {
            throw new RuntimeException("Runnable! " + Thread.currentThread().getName());
        });

        try {
            var result = futureRunnable.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(MessageFormat.format(
                    "Thread is [{0}], message: {1}",
                    Thread.currentThread().getName(),
                    e.getMessage()));
        }
    }

    private static void callableWithException() {
        var factorialCallableTask = new FactorialCallableTask(-5);

        final Future<Integer> futureCallable = executorService.submit(factorialCallableTask);

        while (!futureCallable.isDone()) {
            System.out.println("Do work");
        }

        try {
            futureCallable.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(MessageFormat.format(
                    "Thread is [{0}], message: {1}",
                    Thread.currentThread().getName(),
                    e.getMessage()));
        }
    }
}
