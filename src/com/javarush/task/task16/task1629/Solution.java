package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {

        private final List<String> resultList = new ArrayList<>();

//        public Read3Strings() {
//            super();
//            start();
//        }

        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    String nextLine =reader.readLine();
                    resultList.add(nextLine);
                }
            } catch (IOException e) {
                System.out.println("Something went wrong " + e);
            }
        }

        public void printResult() {
            for (String nextLine : resultList) {
                System.out.print(nextLine + " ");
            }
            System.out.println();
        }
    }
}






























