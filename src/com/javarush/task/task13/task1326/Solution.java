package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<Integer> list = new ArrayList<>();
        while (bufferedReader.ready()) {
            Integer nextNumber = Integer.parseInt(bufferedReader.readLine());
            if (nextNumber % 2 == 0) {
                list.add(nextNumber);
            }
        }
        list.sort(null);
        for (Integer element : list) {
            System.out.println(element);
        }
        fileInputStream.close();
    }
}






























