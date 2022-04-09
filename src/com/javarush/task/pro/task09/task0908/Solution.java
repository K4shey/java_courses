package com.javarush.task.pro.task09.task0908;

public class Solution {

    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {

        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null) {
            return "";
        }
        if (binaryNumber.isEmpty() || !isOnlyBinary(binaryNumber)) {
            return "";
        }
        binaryNumber = complementBinaryNumber(binaryNumber);
        StringBuilder nibble = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            for (int j = 0; j < 4; j++) {
                nibble.append(binaryNumber.charAt(i + j));
            }
            result.append(convertBinaryToHex(nibble));
            nibble.setLength(0);
        }
        return result.toString();
    }

    private static char convertBinaryToHex(StringBuilder nibble) {
        int result = 0;
        for (int i = 0; i < nibble.length(); i++) {
            int nextPosition = nibble.length() - 1 - i;
            int nextDigit = Integer.parseInt(String.valueOf(nibble.charAt(nextPosition)));
            result += nextDigit * Math.pow(2, i);
        }
        return HEX.charAt(result);
    }

    private static String complementBinaryNumber(String binaryNumber) {
        if (binaryNumber.length() % 4 == 0) {
            return binaryNumber;
        } else {
            StringBuilder newString = new StringBuilder();
            newString.append(binaryNumber);
            while (newString.length() % 4 != 0) {
                newString.insert(0, '0');
            }
            return newString.toString();
        }
    }

    private static boolean isOnlyBinary(String binaryNumber) {
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '1' && binaryNumber.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }


    public static String toBinary(String hexNumber) {
        if (hexNumber == null) {
            return "";
        }
        if (hexNumber.isEmpty() || !isOnlyHex(hexNumber)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hexNumber.length(); i++) {
            result.append(convertHexToBinary(hexNumber.charAt(i)));
        }
        return result.toString();
    }

    private static String convertHexToBinary(char nextChar) {

        String result = "";

        switch (nextChar) {
            case '0': result = "0000";
                break;
            case '1': result = "0001";
                break;
            case '2': result = "0010";
                break;
            case '3': result = "0011";
                break;
            case '4': result = "0100";
                break;
            case '5': result = "0101";
                break;
            case '6': result = "0110";
                break;
            case '7': result = "0111";
                break;
            case '8': result = "1000";
                break;
            case '9': result = "1001";
                break;
            case 'a': result = "1010";
                break;
            case 'b': result = "1011";
                break;
            case 'c': result = "1100";
                break;
            case 'd': result = "1101";
                break;
            case 'e': result = "1110";
                break;
            case 'f': result = "1111";
                break;
            default:
                break;
        }
        return result;
//        if (nextChar == '0') {
//            return "0000";
//        }
//        int nextDigit = 0;
//        for (int j = 0; j < HEX.length(); j++) {
//            if (nextChar == HEX.charAt(j)) {
//                nextDigit = j;
//                break;
//            }
//        }
//        StringBuilder newString = new StringBuilder();
//        int result = 0;
//        while (nextDigit != 0) {
//            int remainder = nextDigit % 2;
//            newString.insert(0, remainder);
//            nextDigit = nextDigit / 2;
//        }
//        return newString.toString();
    }

    private static boolean isOnlyHex(String hexNumber) {
        for (int i = 0; i < hexNumber.length(); i++) {
            if (!(hexNumber.charAt(i) >= '0' && hexNumber.charAt(i) <= '9'
                    || hexNumber.charAt(i) >= 'a' && hexNumber.charAt(i) <= 'f')) {
                return false;
            }
        }
        return true;
    }
}
