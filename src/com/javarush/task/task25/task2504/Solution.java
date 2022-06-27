package com.javarush.task.task25.task2504;

/*
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread nextThread : threads) {
            switch (nextThread.getState().toString()) {
                case "NEW":
                    nextThread.start();
                    break;
                case "TIMED_WAITING":
                case "WAITING":
                case "BLOCKED":
                    nextThread.interrupt();
                    break;
                case "RUNNABLE":
                    nextThread.isInterrupted();
                    break;
                case "TERMINATED":
                    System.out.println(nextThread.getPriority());;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

    }
}






























