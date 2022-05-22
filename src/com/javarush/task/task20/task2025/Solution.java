package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {

        List<Long> values = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (long i = 0; i < N; i++) {
            List<Long> digits = new ArrayList<>();
            long n = i;
            while (n > 0) {
                long remainder = n % 10;
                n /= 10;
                digits.add(remainder);
            }
            digits.sort(Long::compareTo);
            long value = 0;
            for (int j = 0; j < digits.size(); j++) {
                value += digits.get(j) * Math.pow(10, digits.size() - j - 1);
            }
//            System.out.println(Arrays.toString(digits.toArray()));
//            System.out.println(value);
            set.add(value);
        }
        values.addAll(set);
        values.sort(Long::compareTo);



        ArrayList<Long> list = new ArrayList<>();
//        for (long i = 0; i < N; i++) {
        for (long i = 0; i < values.size(); i++) {

            int pow = 0;
            long n = i;
//            long n = values.get(i);
            while (n > 0) {
                n /= 10;
                pow++;
            }
//        System.out.println(pow);
//            n = i;
            n = i;
            long sum = 0;
            while (n > 0) {
                long remainder = n % 10;
                n /= 10;
//                System.out.println(remainder);

                double k = Math.pow(remainder, pow);
//                System.out.println("k = " + k);
                sum += k;
//                System.out.println("sum = " + sum);
            }
            if (sum == i) {
//            if (sum == values.get(i)) {
                System.out.println("bongo !! " + sum);
                list.add(sum);
            }
        }
//        Long[] result = list.toArray(new Long[list.size()]);
        int index = 0;
        long[] result = new long[list.size()];
        for (Long element: list) {
            result[index++] = element;
        }
        return result;
    }

//    public static List<Long> prepare(long N) {
//
//        List<Long> result = new ArrayList<>();
//        Set<Long> set = new HashSet<>();
//        for (long i = 0; i < N; i++) {
//            List<Long> digits = new ArrayList<>();
//            long n = i;
//            while (n > 0) {
//                long remainder = n % 10;
//                n /= 10;
//                digits.add(remainder);
//            }
//            digits.sort(Long::compareTo);
//            long value = 0;
//            for (int j = 0; j < digits.size(); j++) {
//                value += digits.get(j) * Math.pow(10, digits.size() - j - 1);
//            }
////            System.out.println(Arrays.toString(digits.toArray()));
////            System.out.println(value);
//            set.add(value);
//        }
//        for (Long value : set) {
//            result.add(value);
//        }
//        result.sort(Long::compareTo);
//        return result;
//    }

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1700)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

//        ArrayList<Long> list = new ArrayList<>();
//        System.out.println(prepare(8208).toString());

//        long a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(1000)));
//        long b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);
//
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
//        System.out.println(Arrays.toString(getNumbers(100000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}






























