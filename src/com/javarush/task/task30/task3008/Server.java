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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType().equals(MessageType.USER_NAME)) {
                    String name = message.getData();
                    if (!name.equals("")) {
                        if (!connectionMap.containsKey(name)) {
                            connectionMap.put(name, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return name;
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                String nextUser = pair.getKey();
                if (!nextUser.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, nextUser));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Something went wrong!");
                }
            }
        }


    }
}

















