package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            List<String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (int i = 0; i < lines.size(); i++) {
                if (i % 2 == 0) {
                    System.out.println(lines.get(i));
                }
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong " + e);
        }
    }
}































