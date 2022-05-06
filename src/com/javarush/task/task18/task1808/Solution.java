package com.javarush.task.task18.task1808;

import java.io.*;

/*
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        String filename3 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(filename1);

        int firstArraySize = 0;
        if (fileInputStream.available() % 2 == 0) {
            firstArraySize = fileInputStream.available() / 2;
        } else {
            firstArraySize = fileInputStream.available() / 2 + 1;
        }

        byte[] byteArray1 = new byte[firstArraySize];
        byte[] byteArray2 = new byte[fileInputStream.available() - firstArraySize];

        FileOutputStream fileOutputStream1 = new FileOutputStream(filename2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(filename3);

        if (fileInputStream.available() > 0) {
            int count1 = fileInputStream.read(byteArray1);
            int count2 = fileInputStream.read(byteArray2);
            fileOutputStream1.write(byteArray1, 0, count1);
            fileOutputStream2.write(byteArray2, 0, count2);
        }
        fileOutputStream1.close();
        fileOutputStream2.close();
        fileInputStream.close();
    }
}






























