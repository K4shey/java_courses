package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String array[] = nextLine.split(" ");
            Date birthDay = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                birthDay = formatter.parse(
                        array[array.length - 3] + "-" +
                                array[array.length - 2] + "-" +
                                array[array.length - 1]);

            } catch (ParseException pe) {
                System.out.println("Something went wrong " + pe);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < array.length - 3; i++) {
                stringBuilder.append(array[i]);
                if (i < array.length - 4) {
                    stringBuilder.append(" ");
                }
            }
            PEOPLE.add(new Person(stringBuilder.toString(), birthDay));
        }
        bufferedReader.close();
//        for (Person person : PEOPLE) {
//            System.out.println(person.getName() + "-" + person.getBirthDate());
//        }
    }
}






























