package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldValueOut = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(byteArray);
        System.setOut(newPrintStream);
        testString.printSomething();
        String lineForParse = byteArray.toString();
        String[] array = lineForParse.split(" ");
        Integer firstNumber = Integer.parseInt(array[0]);
        Integer secondNumber = Integer.parseInt(array[2]);
        Integer result = 0;
        switch (array[1]) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
        }
        String lineToPrint = array[0] + " " + array[1] + " " + array[2] + " = " + result.toString();
        System.setOut(oldValueOut);
        System.out.println(lineToPrint);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}































