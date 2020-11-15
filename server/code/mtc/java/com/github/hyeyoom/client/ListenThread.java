package com.github.hyeyoom.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ListenThread extends Thread {

    private final InputStream in;

    public ListenThread(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("리스너 시작됨");
        while (true) {
            try {
                byte[] bytes = new byte[4192];
                int readCount;
                while ((readCount = in.read(bytes)) != -1) {
                    final String message = new String(bytes, 0, readCount, StandardCharsets.UTF_8);
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
