package com.javarush.task.task20.task2002;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User newUser = new User();
            newUser.setFirstName("Иван");
            newUser.setLastName("Лапшин");
            Calendar calendar = new GregorianCalendar(2019, Calendar.APRIL, 12);
            newUser.setBirthDate(calendar.getTime());
            newUser.setMale(true);
            newUser.setCountry(User.Country.RUSSIA);
            javaRush.users.add(newUser);
            newUser = new User();
            newUser.setFirstName("Оксана");
            newUser.setLastName("Куплинова");
            calendar = new GregorianCalendar(2020, Calendar.SEPTEMBER, 21);
            newUser.setBirthDate(calendar.getTime());
            newUser.setMale(false);
            newUser.setCountry(User.Country.UKRAINE);
            javaRush.users.add(newUser);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream printStream = new PrintStream(outputStream);
            if (users.size() > 0) {
                for (User nextUser : users) {
                    printStream.println(nextUser.getFirstName());
                    printStream.println(nextUser.getLastName());
                    Long dateToSave = nextUser.getBirthDate().getTime();
                    printStream.println(dateToSave.toString());
                    printStream.println(nextUser.isMale());
                    printStream.println(nextUser.getCountry().getDisplayName().toUpperCase());
                }
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()) {
                User newUser = new User();
                newUser.setFirstName(bufferedReader.readLine());
                newUser.setLastName(bufferedReader.readLine());
                newUser.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                newUser.setMale(bufferedReader.readLine().equals("true"));
                newUser.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                users.add(newUser);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}






























