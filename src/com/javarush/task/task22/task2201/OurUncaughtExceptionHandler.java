package com.javarush.task.task22.task2201;

import java.io.PrintWriter;
import java.io.StringWriter;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String firstElement = e.getClass().getSimpleName();
        String secondElement = e.getMessage();
        return String.format(string, firstElement, secondElement, t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String firstElement = e.getMessage();
        String secondElement = e.getClass().getSimpleName();
        return String.format(string, firstElement, secondElement, t.getName());

    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String firstElement = e.getClass().getSimpleName();
        String secondElement = e.getMessage();
        return String.format(string, t.getName(), firstElement, secondElement);
    }
}































