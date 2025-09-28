package com.nastyazhabko.javacore.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ChatRoomMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ChatRoom chatRoom = new ChatRoom();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(()->{
            chatRoom.postMessage("Ivan", "Hello World");
        });

        executorService.execute(()->{
            chatRoom.postMessage("Pavel", "My name is Pavel");
        });

        executorService.execute(()->{
            chatRoom.postMessage("Sveta", "I love pizza");
        });

        executorService.execute(()->{
            chatRoom.postMessage("Tanya", "I love dogs");
        });

        executorService.execute(()->{
            System.out.println("Последнее сообщение: " + chatRoom.getMessages(1));
        });

        executorService.execute(()->{
            System.out.println("Последние 2 сообщения: " + chatRoom.getMessages(2));
        });

        executorService.shutdown();

    }
}
