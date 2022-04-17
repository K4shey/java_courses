package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source filename:");
        String sourceFileName = scanner.nextLine();
        System.out.println("Enter destination filename:");
        String destinationFileName = scanner.nextLine();

        InputStream inputStream = Files.newInputStream(Paths.get(sourceFileName));
        OutputStream outputStream = Files.newOutputStream(Paths.get(destinationFileName));
        byte[] array = new byte[2];
        while (inputStream.available() > 0) {

           int num =  inputStream.read(array);
           if (num > 1) {
               byte tmp = array[0];
               array[0] = array[1];
               array[1] = tmp;
               outputStream.write(array,0,2);
            } else {
               outputStream.write(array,0,1);
           }
        }
        inputStream.close();
        outputStream.close();
    }
}































