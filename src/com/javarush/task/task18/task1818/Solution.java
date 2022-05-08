package com.javarush.task.task18.task1818;

import java.io.*;

/*
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        String filename3 = bufferedReader.readLine();
        bufferedReader.close();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename2));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filename1));
        while (inputStreamReader.ready()) {
            outputStreamWriter.write(inputStreamReader.read());
        }
        inputStreamReader.close();
        inputStreamReader = new InputStreamReader(new FileInputStream(filename3));
        while (inputStreamReader.ready()) {
            outputStreamWriter.write(inputStreamReader.read());
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}






























