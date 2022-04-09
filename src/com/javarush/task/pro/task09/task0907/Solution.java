package com.javarush.task.pro.task09.task0907;

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        StringBuilder sb = new StringBuilder();
        if (decimalNumber > 0) {
            while (decimalNumber != 0) {

                int remainder = decimalNumber % 16;
                sb.insert(0,HEX.charAt(remainder));
                decimalNumber = decimalNumber / 16;
            }
            return sb.toString();
        }
        return "";
    }

    public static int toDecimal(String hexNumber) {
        if (hexNumber == null) {
            return 0;
        }
        if (!hexNumber.isEmpty()){
            int result = 0;
            int power = 0;
            for (int i = 0; i < hexNumber.length() ; i++) {
                char nextChar = hexNumber.charAt(hexNumber.length()-1-i);
                int nextDigit = 0;
                for (int j = 0; j < HEX.length(); j++) {
                    if (nextChar == HEX.charAt(j)){
                        nextDigit = j;
                        break;
                    }
                }
                result +=  nextDigit * Math.pow(16, power++);
            }
            return result;
        }
        return 0;
    }
}

