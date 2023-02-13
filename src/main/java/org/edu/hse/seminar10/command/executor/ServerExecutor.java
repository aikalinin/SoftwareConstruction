package org.edu.hse.seminar10.command.executor;

import lombok.RequiredArgsConstructor;
import org.edu.hse.seminar10.command.request.RequestService;

@RequiredArgsConstructor
public class ServerExecutor implements Executor {

    private final RequestService requestService;

    private final String url;

    @Override
    public void execute() {
        requestService.serverRequest(url);
    }
}
