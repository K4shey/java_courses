package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/*
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String newString = nextLine.replaceAll("\\.", "!");
            bufferedWriter.write(newString);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}






























