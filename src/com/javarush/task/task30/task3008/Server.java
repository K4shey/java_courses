package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        int serverPort = ConsoleHelper.readInt();
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException ioe) {
            System.out.println("Something went wrong!");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException ioe) {
                System.out.println("Failed to send message");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}

















