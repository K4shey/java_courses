package VTB.lecture5.homework1;

import java.util.*;

public class TestDriveHomework1 {

    public static void main(String[] args) {

        String[] array = new String[]{"bear", "monkey", "dog", "cat", "crocodile", "monkey", "cat", "cat"};
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(array));
        System.out.println(uniqueWords);

        Map<String, Integer> countWords = new HashMap<>();
        for (String element : array) {
            if (countWords.containsKey(element)) {
                countWords.put(element, countWords.get(element) + 1);
            } else {
                countWords.put(element, 1);
            }
        }
        System.out.println(countWords);
    }
}
