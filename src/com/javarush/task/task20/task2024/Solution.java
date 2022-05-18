package com.javarush.task.task20.task2024;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
Знакомство с графами
*/

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("d:\\Downloads\\solution.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

            Solution newObject = new Solution();
            objectOutputStream.writeObject(newObject);

        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
    }
}






























