package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter
//                (new Scanner(new FileInputStream("d:\\Downloads\\Person.txt")));
//        System.out.println(personScannerAdapter.read());
//        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException {

            String nextLine = fileScanner.nextLine();
            String[] array = nextLine.split(" ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOfBirth = null;
            try {
                dateOfBirth = formatter.parse(array[3] + "-" + array[4] + "-" + array[5]);
            } catch (ParseException pe) {
                System.out.println("Something went wrong " + pe);
            }
            Person person = new Person(array[1], array[2], array[0], dateOfBirth);
            return person;
        }

        public void close() throws IOException {
            fileScanner.close();
        }

    }
}






























