package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        Map<Integer, Integer> mapOfBytes = new HashMap<>();
        while (fileInputStream.available() > 0) {
            Integer nextByte = fileInputStream.read();
            if (mapOfBytes.containsKey(nextByte)) {
                Integer previousValue = mapOfBytes.get(nextByte);
                mapOfBytes.put(nextByte, ++previousValue);
            } else {
                mapOfBytes.put(nextByte, 1);
            }
        }
        fileInputStream.close();

        Integer minOccurrence = Collections.min(mapOfBytes.values());

        Set<Integer> setOfBytes = mapOfBytes.keySet();
        for (Integer key : setOfBytes) {
            if (Objects.equals(mapOfBytes.get(key), minOccurrence)) {
                System.out.print(key + " ");
            }
        }

        bufferedReader.close();
    }
}






























