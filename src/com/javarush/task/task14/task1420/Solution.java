package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer firstNumber = Integer.parseInt(bufferedReader.readLine());
        Integer secondNumber = Integer.parseInt(bufferedReader.readLine());
        if (firstNumber > secondNumber) {
            System.out.println(gcdByEuclidsAlgorithm(firstNumber, secondNumber));
        } else {
            System.out.println(gcdByEuclidsAlgorithm(secondNumber, firstNumber));
        }
    }

    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

//    public static Set factorize(Integer number) {
//        Set<Integer> set = new HashSet();
//        Integer del = 2;
//        Integer start = number;
//        set.add(1);
//        set.add(number);
//        while (number > 1 && del < start) {
//            if (number % del == 0) {
////                System.out.println("del = " + del);
//                set.add(del);
//                number = number / del;
//            } else {
//                del++;
//            }
//        }
//        return set;
//    }
}






























