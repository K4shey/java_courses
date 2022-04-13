package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/*
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Johnson", 45.4);
        grades.put("Whisley", 42.1);
        grades.put("Holmes", 41.1);
        grades.put("Gilbert", 44.0);
        grades.put("Bronson", 33.5);
    }
}






























