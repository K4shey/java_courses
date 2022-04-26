package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

// -----------------------------Accepted solution ----------------------------------------
//        InputStream inputStream= new FileInputStream(new Scanner(System.in).nextLine());
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
//        inputStream.close();
//        bufferedReader.close();

// -----------------------------Alternative solution ----------------------------------------
//        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(new Scanner(System.in).nextLine()))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            System.out.println("Something went wrong + " + e);
//        }
// -----------------------------Another one alternative solution -----------------------------
        List<String> list = Files.readAllLines(Paths.get(new Scanner(System.in).nextLine()));
        for (String line : list) {
            System.out.println(line);
        }
    }
}





























