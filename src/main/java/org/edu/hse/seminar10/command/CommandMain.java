package org.edu.hse.seminar10.command;

import org.edu.hse.seminar10.command.executor.DatabaseExecutor;
import org.edu.hse.seminar10.command.executor.ServerExecutor;
import org.edu.hse.seminar10.command.request.RemoteRequestService;
import org.edu.hse.seminar10.command.request.RequestService;

public class CommandMain {
    public static void main(String[] args) {
        final ExecutorHandler executorHandler = new ExecutorHandler();
        final RequestService requestService = new RemoteRequestService();

        executorHandler.addExecutor(
                ExecutorHandler.ExecutorName.DATABASE,
                new DatabaseExecutor(
                        requestService,
                        "jdbc://databse",
                        "Anton",
                        "password"
                )
        );

        executorHandler.addExecutor(
                ExecutorHandler.ExecutorName.SERVER,
                new ServerExecutor(
                        requestService,
                        "https://remote.com"
                )
        );

        executorHandler.executeByName(ExecutorHandler.ExecutorName.DATABASE);
        executorHandler.executeAll();
    }
}
