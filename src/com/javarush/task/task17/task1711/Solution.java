package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        createEntry(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        updateEntry(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deleteEntry(Integer.parseInt(args[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        readEntry(Integer.parseInt(args[i]));
                    }
                }
        }
    }

    static private void createEntry(String name, String sex, String date) {
        Person person = null;
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException pe) {
            System.out.println("Something went wrong " + pe);
        }
        person = (sex.equals("ж")) ? Person.createFemale(name, dateOfBirth) : Person.createMale(name, dateOfBirth);
        if (person != null) {
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        }
    }

    static private void updateEntry(int id, String name, String sex, String date) {
        Person person = null;
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException pe) {
            System.out.println("Something went wrong " + pe);
        }
        person = (sex.equals("ж")) ? Person.createFemale(name, dateOfBirth) : Person.createMale(name, dateOfBirth);
        if (person != null) {
            allPeople.remove(id);
            allPeople.add(id, person);
        }
    }

    static private void deleteEntry(int id) {
        Person person = allPeople.get(id);
        person.setSex(null);
        person.setName(null);
        person.setBirthDate(null);
    }

    static private void readEntry(int id) {
        Person person = allPeople.get(id);
        StringBuilder result = new StringBuilder(person.getName());
        result.append(" ").append(person.getSex() == Sex.FEMALE ? "ж" : "м");
        result.append(" ").append(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
        System.out.println(result.toString());
    }

}






























