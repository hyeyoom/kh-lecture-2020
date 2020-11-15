package com.github.hyeyoom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends Thread {

    private final Socket client;
    private OutputStream out;
    private String ip;

    public Client(Socket client) {
        this.client = client;
        ip = client.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        System.out.println("클라이언트 리스너 시작됨");
        try (
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
        ) {
            this.out = out;
            byte[] bytes = new byte[4192];
            int readCount;
            while ((readCount = in.read(bytes)) != -1) {
                final String message = new String(bytes, 0, readCount, StandardCharsets.UTF_8);
                System.out.println(message);
                ClientManager.getInstance().broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String readLine) {
        final OutputStreamWriter osw = new OutputStreamWriter(out);
        try {
            osw.write(readLine);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIp() {
        return this.ip;
    }
}
