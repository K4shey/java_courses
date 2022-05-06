package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<Integer> arrayOfBytes = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filename1);
        FileOutputStream fileOutputStream = new FileOutputStream(filename2);

        while (fileInputStream.available() > 0) {
            arrayOfBytes.add(fileInputStream.read());
        }
        fileInputStream.close();

        Collections.reverse(arrayOfBytes);
        for (Integer element : arrayOfBytes) {
            fileOutputStream.write(element);
        }
        fileOutputStream.close();
    }
}






























