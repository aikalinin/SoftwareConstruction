package org.edu.hse.seminar10.command.request;

public interface RequestService {

    void cacheRequest(String url, String username, String password);

    void serverRequest(String url);
}
