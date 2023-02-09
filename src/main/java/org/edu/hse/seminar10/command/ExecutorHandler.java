package org.edu.hse.seminar10.command;

import org.edu.hse.seminar10.command.executor.Executor;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ExecutorHandler {

    private final Map<ExecutorName, Executor> executors = new EnumMap<>(ExecutorName.class);

    public void addExecutor(final ExecutorName name, final Executor executor) {
        executors.put(name, executor);
    }

    public void executeByName(final ExecutorName name) {
        Optional.ofNullable(executors.get(name)).ifPresent(Executor::execute);
    }

    public void executeAll() {
        executors.values().forEach(Executor::execute);
    }

    enum ExecutorName {
        DATABASE,
        SERVER
    }
}
