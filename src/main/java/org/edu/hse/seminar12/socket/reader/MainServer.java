package org.edu.hse.seminar12.socket.reader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

    public static final int SERVER_PORT = 50001;

    public static void main(String[] args) {
        try (final var server = new ServerSocket(SERVER_PORT);
             final var scanner = new Scanner(System.in)) {
            final Socket clientConnection = server.accept();

            final var threadReader = new ThreadReader(
                    clientConnection.getInputStream(),
                    "Server"
            );
            threadReader.start();

            System.out.println("Client was connected");
            final DataOutput serverOutput = new DataOutputStream(clientConnection.getOutputStream());

            String serverData;

            do {
                serverData = scanner.nextLine();
                serverOutput.writeBytes(serverData + "\n");
            } while (!serverData.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
