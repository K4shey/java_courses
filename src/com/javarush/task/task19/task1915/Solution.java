package com.javarush.task.task19.task1915;

import java.io.*;

/*
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        PrintStream oldValueOut = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArray);
        System.setOut(printStream);
        testString.printSomething();
        fileOutputStream.write(byteArray.toByteArray());
        System.setOut(oldValueOut);
        System.out.println(byteArray.toString());
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}































