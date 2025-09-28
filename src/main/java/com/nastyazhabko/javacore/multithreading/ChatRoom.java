package com.nastyazhabko.javacore.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRoom {
    List<String> messages = new CopyOnWriteArrayList<>();

    public void postMessage(String user, String text) {
        messages.add(user + ": " + text);
        System.out.println("User " + user + " posted: " + text);
        System.out.println(messages);
    }

    public List<String> getMessages(int count) {
        System.out.println("Reading " + count + " messages");
        if (messages.size() > count) {
            List<String> lastMessages = new ArrayList<String>();
            for (int i = messages.size()-count; i < messages.size(); i++) {
                lastMessages.add(messages.get(i));
            }
            return lastMessages;
        }
        return messages;
    }
}
