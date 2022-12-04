package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        if (Long.parseLong(args[1]) > randomAccessFile.length()) {
            randomAccessFile.seek(randomAccessFile.length());
        } else {
            randomAccessFile.seek(Long.parseLong(args[1]));
        }
        randomAccessFile.write(args[2].getBytes());
        randomAccessFile.close();
    }
}






























