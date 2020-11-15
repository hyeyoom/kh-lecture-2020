package com.github.hyeyoom.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            final Socket socket = new Socket("localhost", 12345);
            final ListenThread thread = new ListenThread(socket.getInputStream());
            thread.start();
            startChat(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startChat(Socket socket) {
        try (final OutputStream out = socket.getOutputStream()) {
            final Scanner scanner = new Scanner(System.in);
            final OutputStreamWriter osw = new OutputStreamWriter(out);
            while (true) {
                final String messageToSend = scanner.next();
                if ("!exit".equals(messageToSend)) {
                    break;
                }
                osw.write(messageToSend);
                osw.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
