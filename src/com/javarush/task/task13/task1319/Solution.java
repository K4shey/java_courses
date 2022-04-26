package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        Boolean pathEntered = false;
//        ArrayList<String> list = new ArrayList<>();
//        String filePath = "";
//        while (scanner.hasNext()) {
//            String nextLine = scanner.nextLine();
//            if (!pathEntered) {
//                filePath = nextLine;
//                pathEntered = true;
//            } else if (!nextLine.toLowerCase(Locale.ROOT).equals("exit")) {
//                list.add(nextLine);
//            } else {
//                break;
//            }
//        }
//        list.add("exit");
//        try {
//            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(filePath));
//            for (String line : list) {
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (Exception e) {
//            System.out.println("Something went wrong + " + e);
//        }

        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()));
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            if (line.equals("exit")) {
                break;
            }
        }
        bufferedWriter.close();
    }
}




























