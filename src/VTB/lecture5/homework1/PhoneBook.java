package VTB.lecture5.homework1;

import java.util.*;

public class PhoneBook {
    private Map<String, HashSet<String>> entries = new HashMap<>();

    public void add(String surname, String phoneNumber) {

//        if (entries.containsKey(surname)) {
//            entries.get(surname).add(phoneNumber);
//        } else {
//            HashSet<String> phoneNumbers = new HashSet<>();
//            phoneNumbers.add(phoneNumber);
//            entries.put(surname, phoneNumbers);
//        }
        if (!entries.containsKey(surname)) {
            entries.put(surname, new HashSet<>());
        }
        entries.get(surname).add(phoneNumber);
    }

    public Set<String> get(String surname) {
        if (entries.containsKey(surname)) {
            return entries.get(surname);
        }
        return null;
    }

}
