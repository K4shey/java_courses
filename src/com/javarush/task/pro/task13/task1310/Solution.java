package com.javarush.task.pro.task13.task1310;

import java.util.HashMap;
import java.util.Set;

/*
Успеваемость студентов-2
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println("Список студентов группы: ");
        printStudents();
        System.out.print("Средний балл группы: " + getAverageMark());
    }

    public static void addStudents() {
        grades.put("Давыдов Олег", 4.3d);
        grades.put("Шульга Николай", 4.1d);
        grades.put("Колос Василий", 4.9d);
        grades.put("Шевченко Тарас", 3.7d);
        grades.put("Марчук Любослав", 3.2d);
    }

    public static void printStudents() {
        Set<String> students = grades.keySet();
        for (String student: students) {
            System.out.println(student);
        }
    }

    public static Double getAverageMark() {
        Double averageMark = 0.0;
        for (Double mark: grades.values()) {
            averageMark += mark;
        }
        return averageMark / grades.size();
    }
}





























