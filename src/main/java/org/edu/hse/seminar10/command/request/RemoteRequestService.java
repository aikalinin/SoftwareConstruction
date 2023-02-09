package org.edu.hse.seminar10.command.request;

import java.text.MessageFormat;

public class RemoteRequestService implements RequestService {


    @Override
    public void cacheRequest(String url, String username, String password) {
        System.out.println(MessageFormat.format(
                "Connected to {0} by {1}:{2}",
                url,
                username,
                password
        ));
    }

    @Override
    public void serverRequest(String url) {
        System.out.println("Response from server by " + url);
    }
}
