package com.github.hyeyoom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 1. 리스닝(외부의 데이터 받고(InputStream 읽기) 화면에 출력)
 * 2. 전송(OutputStream에 쓰기)
 */
public class Client extends Thread {

    private final Socket socket;
    private final String clientIp;

    // 클라이언트에게 전송하기 위한 output stream
    private OutputStream out;

    // 생성자
    public Client(Socket socket) {
        this.socket = socket;
        clientIp = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        System.out.println("클라이언트 리스너 시작됨: " + clientIp);
        try (
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
        ) {
            this.out = out;
            final byte[] bytes = new byte[4096];
            int readCount;
            while ((readCount = in.read(bytes)) != -1) {
                final String message = new String(bytes, 0, readCount, StandardCharsets.UTF_8);
                final String msg = String.format("[%s]: %s", clientIp, message);
                ClientManager.getInstance().broadcast(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClientIp() {
        return clientIp;
    }

    public void send(String message) {
        final OutputStreamWriter osw = new OutputStreamWriter(out);
        try {
            osw.write(message);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}