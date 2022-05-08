package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].equals("-u") && !args[0].equals("-d")) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        switch (args[0]) {
            case "-u":
                updateItem(filename, args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                deleteItem(filename, args[1]);
        }
    }

    public static void updateItem(String filename, String id, String name, String price, String quantity) throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String result = "";
        while (bufferedReader.ready()) {
            result = bufferedReader.readLine();
            int currentId = Integer.parseInt(result.substring(0, 8).trim());
            if (currentId == Integer.parseInt(id)) {
                result = String.format("%-8d%-30s%-8s%-4s", currentId, name, price, quantity);
            }
            list.add(result + "\n");
        }
        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        for (String item : list) {
            bufferedWriter.write(item);
        }
        bufferedWriter.close();
    }

    public static void deleteItem(String filename, String id) throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String result = "";
        int index = 0;
        int indexToRemove = -1;
        while (bufferedReader.ready()) {
            result = bufferedReader.readLine();
            list.add(result + "\n");
            int currentId = Integer.parseInt(result.substring(0, 8).trim());
            if (currentId == Integer.parseInt(id)) {
                indexToRemove = index;
            }
            index++;
        }
        bufferedReader.close();
        if (indexToRemove != -1) {
            list.remove(indexToRemove);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        for (String item : list) {
            bufferedWriter.write(item);
        }
        bufferedWriter.close();
    }
}
