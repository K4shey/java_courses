package com.javarush.task.pro.task17.task1708;

/*
Минимальное и максимальное
*/

public class MinMaxUtil {

    public static int max(int val1, int val2) {
        return val1 > val2 ? val1:val2;
    }

    public static int max(int val1, int val2, int val3) {
        int a = val1 > val2 ? val1:val2;
        return a > val3 ? a:val3;
    }

    public static int max(int val1, int val2, int val3, int val4) {
        int a = val1 > val2 ? val1:val2;
        int b = val3 > val4 ? val3:val4;
        return a > b ? a:b;
    }

    public static int max(int val1, int val2, int val3, int val4, int val5) {
        int a = val1 > val2 ? val1:val2;
        int b = val3 > val4 ? val3:val4;
        int c =  a > b ? a:b;
        return c > val5 ? c:val5;
    }

    public static int min(int val1, int val2) {
        return Math.min(val1, val2);
    }

    public static int min(int val1, int val2, int val3) {
        int a = Math.min(val1, val2);
        return Math.min(a, val3);
    }

    public static int min(int val1, int val2, int val3, int val4) {
        int a = Math.min(val1, val2);
        int b = Math.min(val3, val4);
        return Math.min(a, b);
    }

    public static int min(int val1, int val2, int val3, int val4, int val5) {
        int a = Math.min(val1, val2);
        int b = Math.min(val3, val4);
        int c = Math.min(a, b);
        return Math.min(c, val5);
    }
    
    

    public static void main(String[] args) {
        System.out.println(min(3, 5, 20, 21, 43));
    }

}






























