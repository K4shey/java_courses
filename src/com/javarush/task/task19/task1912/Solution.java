package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(byteArray);
        System.setOut(newPrintStream);
        testString.printSomething();
        String modifiedString = byteArray.toString().replaceAll("te","??");
        System.setOut(consoleOut);
        System.out.println(modifiedString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}






























