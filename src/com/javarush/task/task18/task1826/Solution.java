package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Шифровка
*/

public class Solution {
    private static final int KEY = 255;

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e") || args[0].equals("-d")) {
            encode(args[1], args[2]);
        }
    }

    public static void encode(String fileName, String fileOutputName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream((fileOutputName));
        while (fileInputStream.available() > 0) {
            int source = fileInputStream.read();
            int dest = source ^ KEY;
            fileOutputStream.write(dest);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}






























