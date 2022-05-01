package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    static class Thread1 extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    static class Thread3 extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Thread4 extends Thread implements Message {
        static boolean keepRunning = true;

        public void run() {
            while (keepRunning) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }

        public void showWarning() {
            keepRunning = false;
        }
    }

    static class Thread5  extends Thread  {
        public void run() {
            int sum = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String nextLine = bufferedReader.readLine();
                while (!nextLine.equals("N")) {
                    try {
                        Thread.sleep(1);
                        sum += Integer.parseInt(nextLine);
                    } catch (InterruptedException e) {
                    }
                    nextLine = bufferedReader.readLine();
                }
                System.out.println(sum);
                bufferedReader.close();

            } catch (IOException ioe){

            }
        }
    }

}





























