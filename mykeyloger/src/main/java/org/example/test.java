package org.example;

import dyorgio.runtime.jinputhook.GlobalKeyListener;
import dyorgio.runtime.jinputhook.JInputHook;
import net.java.games.input.Component;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public class test {
    public static void main(String[] args) throws Exception{
        JInputHook.initialize();
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        ChatClient client = new ChatClient();
        container.connectToServer(client, URI.create("ws://localhost:8080/chat"));
        JInputHook.addListener(new GlobalKeyListener() {
            @Override
            public void keyPressed(Component.Identifier.Key key) {
                System.out.print(key);
                client.sendMessage(key.toString());
            }

            @Override
            public void keyReleased(Component.Identifier.Key key) {
                System.out.print(key);
                client.sendMessage(key.toString());
            }
        });
        while (true);

    }
}
