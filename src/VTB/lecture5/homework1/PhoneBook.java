package VTB.lecture5.homework1;

import java.util.*;

public class PhoneBook {
    private Map<String, String> entries = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        entries.put(phoneNumber, surname);
    }

    public Set<String> get(String surname) {
        Set<String> result = new HashSet<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            if (surname.equals(entry.getValue())) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
