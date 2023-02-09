package org.edu.hse.seminar10.command.executor;

import lombok.RequiredArgsConstructor;
import org.edu.hse.seminar10.command.request.RequestService;

@RequiredArgsConstructor
public class DatabaseExecutor implements Executor {

    private final RequestService requestService;

    private final String url;

    private final String username;

    private final String password;

    @Override
    public void execute() {
        requestService.cacheRequest(url, username, password);
    }
}
