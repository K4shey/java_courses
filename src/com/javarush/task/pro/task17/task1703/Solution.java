package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/*
Космическая одиссея ч.1
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        Human human1 = new Human();
        Human human2 = new Human();
        Dog dog = new Dog();
        Cat cat = new Cat();
        astronauts.add(human1);
        astronauts.add(human2);
        astronauts.add(cat);
        astronauts.add(dog);
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}






























