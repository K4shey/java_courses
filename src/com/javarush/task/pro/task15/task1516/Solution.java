package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            Path path = Path.of(scanner.nextLine());
            while (Files.exists(path)) {
                if (Files.isDirectory(path)) {
                    System.out.println(path + " " + THIS_IS_DIR);
                } else if (Files.isRegularFile(path)) {
                    System.out.println(path  + THIS_IS_FILE);
                }
                path = Path.of(scanner.nextLine());
            }
        } catch (Exception e){
            System.out.println("Something went wrong" + e);
        }
    }
}































