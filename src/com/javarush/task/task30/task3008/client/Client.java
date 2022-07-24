package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    volatile private boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter address of server");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter port of server");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter user's name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ioe) {
            ConsoleHelper.writeMessage("Message sending error");
            clientConnected = false;
        }

    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " connected to the chat");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " left the chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == null) {
                    throw new IOException("Unexpected MessageType");
                }
                if (message.getType().equals(MessageType.NAME_REQUEST)) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (message.getType().equals(MessageType.NAME_ACCEPTED)) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == null) {
                    throw new IOException("Unexpected MessageType");
                }
                if (message.getType().equals(MessageType.TEXT)) {
                    processIncomingMessage(message.getData());
                } else if (message.getType().equals(MessageType.USER_ADDED)) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType().equals(MessageType.USER_REMOVED)) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                connection = new Connection(new Socket(serverAddress, serverPort));
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ConsoleHelper.writeMessage("Something went wrong");
                System.exit(0);
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента");
        }

        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equals("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(text);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}
