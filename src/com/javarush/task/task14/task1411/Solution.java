package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();
        //тут цикл по чтению ключей, пункт 1
        while (key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("proger")) {
            //создаем объект, пункт 2
            switch (key) {
                case ("user"):
                    person = new Person.User();
                    break;
                case ("loser"):
                    person = new Person.Loser();
                    break;
                case ("coder"):
                    person = new Person.Coder();
                    break;
                case ("proger"):
                    person = new Person.Proger();
                    break;
            }
            doWork(person); //вызываем doWork
            key = reader.readLine();
        }
        reader.close();
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            Person.User user = (Person.User) person;
            user.live();
        } else if (person instanceof Person.Loser) {
            Person.Loser loser = (Person.Loser) person;
            loser.doNothing();
        } else if (person instanceof Person.Coder) {
            Person.Coder user = (Person.Coder) person;
            user.writeCode();
        } else if (person instanceof Person.Proger) {
            Person.Proger user = (Person.Proger) person;
            user.enjoy();
        }
    }
}






























