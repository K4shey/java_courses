package com.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/*
Переворачивание данных
*/

public class Solution {
//    public static int[] numbers = new int[10];
    public static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
//            numbers[i] = i;
            numbers.add(i, i);
        }
    }

    public static void reverse() {
//        int n = numbers.length - 1;
        int n = numbers.size() - 1;
//        for (int i = 0; i < numbers.length / 2; i++) {
        for (int i = 0; i < numbers.size() / 2; i++) {
//            int temp = numbers[i];
            int temp = numbers.get(i);
//            numbers[i] = numbers[n - i];
            numbers.set(i, numbers.get(n - i));
//            numbers[n - i] = temp;
            numbers.set(n - i, temp);
        }
    }

    private static void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}






























