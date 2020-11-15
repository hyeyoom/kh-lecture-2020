package com.github.hyeyoom.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    private static final ClientManager INSTANCE = new ClientManager();

    private final List<Client> clients = new ArrayList<>();

    private ClientManager() {
    }

    public static ClientManager getInstance() {
        return INSTANCE;
    }

    private void addClient(Socket client) {
        final Client clientThread = new Client(client);
        clients.add(clientThread);
        clientThread.start();
    }

    public static void registerClient(Socket client) {
        getInstance().addClient(client);
    }

    public void broadcast(String message) {
        System.out.println("보낼 메세지: " + message);
        for (Client client : clients) {
            client.send(String.format("[%s]: %s", client.getIp(), message));
        }

    }
}
