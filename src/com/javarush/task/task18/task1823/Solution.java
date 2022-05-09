package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        while (!filename.equals("exit")) {
            Thread newThread = new ReadThread(filename);
            newThread.start();
            filename = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            Integer[] array = new Integer[256];
            Arrays.fill(array, 0);
            String filename = getName();
            try {

                FileInputStream fileInputStream = new FileInputStream(filename);
                while (fileInputStream.available() > 0) {
                    Integer nextByte = fileInputStream.read();
                    array[nextByte]++;
                }
                fileInputStream.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("Something went wrong " + fnfe);
            } catch (IOException ioe) {
                System.out.println("Something went wrong " + ioe);
            }
            Integer maxValue = array[0];
            Integer indexMaxValue = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                    indexMaxValue = i;
                }
            }
            synchronized (resultMap) {
                resultMap.put(filename, indexMaxValue);
            }
        }
    }
}






























