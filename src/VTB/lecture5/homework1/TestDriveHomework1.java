package VTB.lecture5.homework1;

import java.util.*;

public class TestDriveHomework1 {

    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        String[] array = new String[]{"bear", "monkey", "dog", "cat", "crocodile", "monkey", "cat", "cat"};
        Map<String, Integer> countWords = new HashMap<>();
        for (String element : array) {
            if (countWords.containsKey(element)) {
                countWords.put(element, countWords.get(element) + 1);
            } else {
                countWords.put(element, 1);
            }
        }
        System.out.println("Unique words:");
        System.out.println(countWords.keySet());
        System.out.println("Words counter:");
        System.out.println(countWords);

        initializePhoneBook();
        getNumbersBySurname("Ivanov");
        getNumbersBySurname("Kuzmin");
        getNumbersBySurname("Petrov");
        getNumbersBySurname("Petroff");

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
        Set<String> phonesSet = phoneBook.get(surname);
        if (phonesSet != null) {
            System.out.println("Phone number(s):");
            for (String element : phoneBook.get(surname)) {
                System.out.println(element);
            }
        } else {
            System.out.println("No phone numbers for this surname, sorry.");
        }
    }
}
