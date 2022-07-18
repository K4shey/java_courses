package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}





























