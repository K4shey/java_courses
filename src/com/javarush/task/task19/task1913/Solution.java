package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldConsoleOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(byteArray);
        System.setOut(newPrintStream);
        testString.printSomething();
        String onlyNumbers = byteArray.toString().replaceAll("[^\\d]","");
//                .replaceAll("\\p{Alpha}","")
//                .replaceAll("\\p{Punct}", "")
//                .replaceAll("\\s","");
        System.setOut(oldConsoleOut);
        System.out.println(onlyNumbers);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}






























