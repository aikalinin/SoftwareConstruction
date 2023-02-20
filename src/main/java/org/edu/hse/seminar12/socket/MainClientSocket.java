package org.edu.hse.seminar12.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainClientSocket {

    public static void main(String[] args) {
        try (final var clientSocket = new Socket("localhost", 50001);
             final var reader = new InputStreamReader(clientSocket.getInputStream());
             final var bufferedReader = new BufferedReader(reader)) {
            final String receivedData = bufferedReader.readLine();

            System.out.println("Received Data: " + receivedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
