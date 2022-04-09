package com.javarush.task.pro.task09.task0905;

/*
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("res=" + toOctal(6175));
        System.out.println("res=" + toDecimal(37));
    }

    public static int toOctal(int decimalNumber) {
        if (decimalNumber > 0) {
            int result = 0;
            int power = 0;
            while (decimalNumber != 0) {
                result += (decimalNumber % 8) * Math.pow(10, power++);
                decimalNumber = decimalNumber / 8;
            }
            return result;
        }
        return 0;
    }

    public static int toDecimal(int octalNumber) {
        if (octalNumber > 0) {
            int result = 0;
            int power = 0;
            while (octalNumber != 0) {
                result += (octalNumber % 10) * Math.pow(8, power++);
                octalNumber = octalNumber / 10;
            }
            return result;
        }
            return 0;
    }
}
