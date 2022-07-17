package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        while (true) {
            try {
                String result = bufferedReader.readLine();
                if (result != null) {
                    return result;
                }
            } catch (IOException ioe) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз");
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                int result = Integer.parseInt(readString());
                return result;
            } catch (NumberFormatException nfe) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз");
            }
        }
    }

}
