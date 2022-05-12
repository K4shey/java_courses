package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
Считаем зарплаты
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
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();
        for (Map.Entry<String, Double> entry : set) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}






























