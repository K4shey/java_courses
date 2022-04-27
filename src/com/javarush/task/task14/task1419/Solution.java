package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer a = null;
            if (a > 0) {
                System.out.println("Is positive");
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList a = new ArrayList();
            a.get(5);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List<Integer> ints = new ArrayList();
            ints.add(6);
            ints.add(2);
            Iterator iterator = ints.iterator();
            while (iterator.hasNext()) {
                iterator.remove();
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String str = "My beautiful string";
            char nextChar = str.charAt(20);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File myfile = new File("E://file.txt");
            FileReader fileReader = new FileReader(myfile);
            String str = "My beautiful string";
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int num = Integer.parseInt("five");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] array = new int[5];
            array[6] = 9;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchMethodException();
        } catch (Exception e) {
            exceptions.add(e);
        }

    }

}






























