package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null || telNumber.equals("")) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[()]?){12}$"))
                && (telNumber.matches("^([()]?\\d){10}$"))
                || (telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$"));

    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+132456345965"));
        System.out.println(checkTelNumber("+13(245)6345965"));
        System.out.println(checkTelNumber("(245)6345965"));
        System.out.println(checkTelNumber("0(245)634596"));
        System.out.println(checkTelNumber("+38)245(6345965"));
        System.out.println(checkTelNumber("+38(245)634-59-65"));
        System.out.println(checkTelNumber("245xxx5965"));
        System.out.println(checkTelNumber("050112345"));
        System.out.println(checkTelNumber("(0)501123456"));
    }
}






























