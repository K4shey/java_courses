package com.javarush.task.task25.task2512;

import java.util.*;

/*
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (!t.isInterrupted()) {
            t.interrupt();
        }
        Throwable cause = e;
        List<Throwable> list = new ArrayList<>();
        while (cause.getCause() != null) {
            list.add(cause);
            cause = cause.getCause();
        }
        list.add(cause);
        Collections.reverse(list);
        for (Throwable nextCause : list) {
            System.out.println(nextCause);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalArgumentException("GHI")));
            }
        });
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}






























