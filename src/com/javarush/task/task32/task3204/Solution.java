package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
Генератор паролей
*/

public class Solution {

    public static final int PASSWORD_LENGTH = 8;

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword(){

        char[] pass = new char[PASSWORD_LENGTH];

        while (true) {
            int symbol_type = (int) (Math.random() * 3);
            int position = (int) (Math.random() * PASSWORD_LENGTH);
            if (symbol_type == 0) {
                int nextChar = 97 + (int) (Math.random() * 26); //lower case
                pass[position] = (char) nextChar;
            } else if (symbol_type == 1) {
                int nextChar = 48 + (int) (Math.random() * 10); //digit
                pass[position] = (char) nextChar;
            } else if (symbol_type == 2) {
                int nextChar = 65 + (int) (Math.random() * 26); //upper case
                pass[position] = (char) nextChar;
            }

            if (checkDigits(pass) && checkLowerCase(pass) && checkUpperCase(pass)  && checkComplete(pass)) {
                break;
            }
        }
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            result.write(new String(pass).getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static boolean checkDigits(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 48 && array[i] <= 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLowerCase(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 97 && array[i] <= 122) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUpperCase(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 90) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkComplete(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return false;
            }
        }
        return true;
    }

}






























