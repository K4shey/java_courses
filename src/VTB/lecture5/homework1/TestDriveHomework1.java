package VTB.lecture5.homework1;

import java.util.*;

public class TestDriveHomework1 {

    private static PhoneBook phoneBook = new PhoneBook();

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

        initializePhoneBook();
        getNumbersBySurname("Ivanov");
        getNumbersBySurname("Kuzmin");
        getNumbersBySurname("Petrov");

    }

    public static void initializePhoneBook() {
        phoneBook.add("Ivanov", "223322");
        phoneBook.add("Ivanov", "778866");
        phoneBook.add("Ivanov", "117722");
        phoneBook.add("Petrov", "655435");
        phoneBook.add("Kuzmin", "9988877");
        phoneBook.add("Sidorov", "641356");
        phoneBook.add("Kuzmin", "1234567");
    }

    public static void getNumbersBySurname(String surname) {
        System.out.println("Surname:" + surname);
        System.out.println("Phone number(s):");
        for (String element : phoneBook.get(surname)) {
            System.out.println(element);
        }
    }
}
