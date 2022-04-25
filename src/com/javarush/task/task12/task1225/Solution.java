package com.javarush.task.task12.task1225;

/*
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        if (o.getClass().equals(Cat.class)) {
            return "Кот";
        } else if (o.getClass().equals(Tiger.class)) {
            return "Тигр";
        } else if (o.getClass().equals(Lion.class)) {
            return "Лев";
        } else if (o.getClass().equals(Bull.class)) {
            return "Бык";
        } else if (o.getClass().equals(Cow.class)) {
            return "Корова";
        } else
            return "Животное";
    }

    static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    static class Tiger extends Cat {
    }

    static class Lion extends Cat {
    }

    static class Bull extends Animal {
    }

    static class Cow extends Animal {
    }

    static class Animal {
    }
}






























