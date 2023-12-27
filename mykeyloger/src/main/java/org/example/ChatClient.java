package org.example;

import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class ChatClient{
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("Connected to server.");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received message from server: " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("Connection closed.");
    }

    public void sendMessage(String message) {
        session.getAsyncRemote().sendText(message);
    }
}
