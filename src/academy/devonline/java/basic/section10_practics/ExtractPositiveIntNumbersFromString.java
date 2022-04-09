package academy.devonline.java.basic.section10_practics;

import java.util.Arrays;

public class ExtractPositiveIntNumbersFromString {
    public static void main(String[] args) {
        // read source data
        String string = "Hello 1234 from 23, or java - is not java11!-2.3 is not a 24";
        // processing
        int[] numbers = extractNumbersFromString(string);
        // display results
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] extractNumbersFromString(String sourceString) {
        int i = 0;
        int j = 0;
        int[] array = new int[sourceString.length() / 2 + 1];

        while (i < sourceString.length()) {
            StringBuilder tempString = new StringBuilder();
            while (sourceString.charAt(i) >= '0' && sourceString.charAt(i) <= '9') {
                tempString.append(sourceString.charAt(i));
                i++;
                if (i >= sourceString.length()) {
                    break;
                }
            }
            if (tempString.isEmpty()) {
                i++;
            } else {
//                System.out.println(tempString);
                array[j] = Integer.parseInt(tempString.toString());
                j++;
            }
        }

        int[] resultArray = new int[j];

        for (int k = 0; k < j; k++) {
            resultArray[k] = array[k];
        }
        return resultArray;
    }
}
