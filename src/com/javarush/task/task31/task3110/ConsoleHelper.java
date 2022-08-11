package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static void writeMessage(String message) throws IOException {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            while (result == null) {
                if (bufferedReader.ready()) {
                    result = bufferedReader.readLine();
                }
            }
        }
        return result;
    }

    public static int readInt() throws IOException {
        int result = 0;
        result = Integer.parseInt(readString());
        return result;
    }

}
