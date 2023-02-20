package org.edu.hse.seminar12.socket;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServerSocket {
    public static final int SERVER_PORT = 50001;

    public static void main(String[] args) {
        try (var server = new ServerSocket(SERVER_PORT)) {
            final Socket clientConnection = server.accept();
            final DataOutput serverOutput = new DataOutputStream(clientConnection.getOutputStream());

            serverOutput.writeBytes("Java revisited\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
