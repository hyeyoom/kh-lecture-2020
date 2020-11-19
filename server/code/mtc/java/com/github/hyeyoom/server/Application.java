package com.github.hyeyoom.server;

public class Application {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(PORT);
            Socket client;
            System.out.println("ㅇㅇ");
            while ((client = serverSocket.accept()) != null) {
                System.out.println("새로운 클라이언트 접속!");
                ClientManager.registerClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}