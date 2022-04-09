package academy.devonline.java.basic.section11_decomposition;

import java.util.Arrays;
import java.util.Locale;

public class FindPopularWord {
    public static void main(String[] args) {
        String text = "hello java world java hello I Hello Java World java";
        String[] array = CreateArrayOfWords(text);
        CreateArrayOfUniqueWords(array);
    }

    private static void CreateArrayOfUniqueWords(String[] array) {
        String[] newArray = new String[array.length];
        int[] numOfRepeat = new int[array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            boolean alreadyInArray = false;
            for (int j = 0; j < newArray.length; j++) {
                if (array[i].equals(newArray[j])) {
                    alreadyInArray = true;
                    numOfRepeat[j]++;
                }
            }
            if (!alreadyInArray) {
                newArray[k] = array[i];
                numOfRepeat[k] = 1;
                k++;
            }
        }
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(numOfRepeat));
        int lengthOfFinalArray = getLenghtNonZeroValuesArray(numOfRepeat);

        while (lengthOfFinalArray >= 0) {
            for (int i = lengthOfFinalArray - 1; i >= 0; i--) {
                if (numOfRepeat[i] < numOfRepeat[i + 1]) {
                    int temp = numOfRepeat[i];
                    numOfRepeat[i] = numOfRepeat[i + 1];
                    numOfRepeat[i + 1] = temp;
                    String tempS = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = tempS;
                }
            }
            lengthOfFinalArray--;
        }
        System.out.println("Word " + newArray[0] + " repeats " + numOfRepeat[0] + " times");

    }

    private static int getLenghtNonZeroValuesArray(int[] array) {
        int index = 0;
        while (array[index] != 0) {
            index++;
        }
        System.out.println(index);
        return index;
    }

    private static String[] CreateArrayOfWords(String text) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int countWords = 1;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                while (text.charAt(i) == ' ') {
                    i++;
                    if (i == text.length()) {
                        break;
                    }
                }
                if (!result.isEmpty()) {
                    result.append(' ');
                    countWords++;
                }
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        System.out.println(countWords);
        String[] uniqueWords = new String[countWords];
        String strForProcessing = result.toString().toLowerCase(Locale.ROOT);
        int index = 0;
        for (int j = 0; j < strForProcessing.length(); j++) {
            String nextWord = getNextWord(strForProcessing, j);
            uniqueWords[index] = nextWord;
            index++;
            j += nextWord.length();
        }
        return uniqueWords;
    }

    private static String getNextWord(String text, int j) {
        StringBuilder result = new StringBuilder();
        while (text.charAt(j) != ' ') {
            result.append(text.charAt(j));
            j++;
            if (j == text.length()) {
                break;
            }
        }
        return result.toString();
    }
}
