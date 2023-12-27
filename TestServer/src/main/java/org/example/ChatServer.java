package org.example;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class ChatServer {
    int cnt = 0;
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println(session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        String filePath = session.getId() + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write(message);
        if(cnt >= 25){
            writer.write("\n");
            cnt = 0;
        }
        ++cnt;
        writer.close();

    }
}
