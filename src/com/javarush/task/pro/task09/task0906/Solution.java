package com.javarush.task.pro.task09.task0906;

/*
Двоичный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {

        if (decimalNumber > 0) {
            StringBuilder sb = new StringBuilder();
            int result = 0;
            while (decimalNumber != 0) {
                int remainder = decimalNumber % 2;
                sb.insert(0,remainder);
                decimalNumber = decimalNumber / 2;
            }
            return sb.toString();
        }
        return "";
    }

    public static int toDecimal(String binaryNumber) {

        if (binaryNumber == null) {
            return 0;
        }
        if (!binaryNumber.isEmpty()) {
            int result = 0;
            for (int i = 0; i < binaryNumber.length(); i++) {
                int nextPosition = binaryNumber.length()-1-i;
                int nextDigit = Integer.parseInt(String.valueOf(binaryNumber.charAt(nextPosition)));
                result += nextDigit * Math.pow(2, i);
            }
            return result;
        }
        return 0;
    }
}







