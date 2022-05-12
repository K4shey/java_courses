package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        Map<String, Double> treeMap = new TreeMap<>();
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String[] array = nextLine.split(" ");
            String name = array[0];
            Double value = Double.parseDouble(array[1]);
            if (!treeMap.containsKey(name)) {
                treeMap.put(name, value);
            } else {

                Double prevValue = treeMap.get(name);
                prevValue += value;
                treeMap.put(name, prevValue);
            }
        }

        bufferedReader.close();

        Double maxValue = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println(entry.getKey());
            }
        }
    }
}






























