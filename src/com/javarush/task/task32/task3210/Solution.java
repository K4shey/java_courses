package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/*
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        int pos = Integer.parseInt(args[1]);
        String paramText = args[2];
        int len = paramText.length();
        byte[] buffer = new byte[len];
        randomAccessFile.seek(pos);
        randomAccessFile.read(buffer, 0, len);
        String fileText = new String(buffer, Charset.defaultCharset());
        randomAccessFile.seek(randomAccessFile.length());
        if (fileText.equals(paramText)) {
            randomAccessFile.write("true".getBytes());
        }
        else {
            randomAccessFile.write("false".getBytes());
            }
        randomAccessFile.close();
    }
}






























