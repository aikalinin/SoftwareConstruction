package org.edu.hse.seminar12.socket.reader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class ThreadReader extends Thread {

    private final InputStream inputStream;

    private final String clientName;

    public ThreadReader(InputStream inputStream, String clientName) {
        this.inputStream = inputStream;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        try (final var reader = new InputStreamReader(inputStream)) {
            final var bufferedReader = new BufferedReader(reader);
            String receivedData;
            do {
                receivedData = bufferedReader.readLine();
                System.out.println(MessageFormat.format(
                        "[{0}] Received Data: {1}",
                        clientName,
                        receivedData));
            } while (!receivedData.equals("exit"));
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " exception");
        }
    }
}
