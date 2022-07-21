package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;
    volatile private boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter address of server");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter port of server");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter user's name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ioe) {
            ConsoleHelper.writeMessage("Message sending error");
            clientConnected = false;
        }

    }

    public class SocketThread extends Thread {

    }
}
