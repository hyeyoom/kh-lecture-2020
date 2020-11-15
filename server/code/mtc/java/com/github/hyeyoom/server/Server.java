package com.github.hyeyoom.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private static boolean isRunning = false;

    @Override
    public void run() {
        try {
            final ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server has been started.");
            Socket client;
            while ((client = serverSocket.accept()) != null) {
                System.out.println("새로운 클라이언트가 접속함.");
                ClientManager.registerClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ignite() {
        if (!isRunning) {
            isRunning = true;
            final Server server = new Server();
            server.start();
        }
    }
}
