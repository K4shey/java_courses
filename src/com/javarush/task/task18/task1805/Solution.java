package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        Set<Integer> set = new TreeSet<>();
        FileInputStream fileInputStream = new FileInputStream(filename);

        while (fileInputStream.available() >0) {
            set.add(fileInputStream.read());
        }

        Iterator<Integer> setIterator = set.iterator();
        while (setIterator.hasNext()) {
            System.out.print(setIterator.next() + " ");
        }

        fileInputStream.close();
    }
}






























