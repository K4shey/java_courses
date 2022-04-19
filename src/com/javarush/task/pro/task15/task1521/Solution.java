package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try (InputStream inputStream = new URL(line).openStream()){
//            Path path = Files.createTempFile(null, ".png");
            Path path = Files.createTempFile(null, null);
              Files.write(path, inputStream.readAllBytes());
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
    }
}





























