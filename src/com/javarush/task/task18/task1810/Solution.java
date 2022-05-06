package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (bufferedReader.ready()) {
            FileInputStream inputStreamReader = new FileInputStream(bufferedReader.readLine());
            if (inputStreamReader.available() < 1000) {
                bufferedReader.close();
                inputStreamReader.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}






























