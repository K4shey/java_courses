package com.javarush.task.task26.task2603;

import java.util.*;

/*
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {

        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Ivanov", 166));
        soldiers.add(new Soldier("Sidorov", 175));
        soldiers.add(new Soldier("Petrov", 185));
        soldiers.add(new Soldier("Sidorov", 177));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name + " " + soldier.height);
        }
        System.out.println("----------------------------------------------------");

        Comparator<Soldier> nameComporator = new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Soldier> heightComporator = new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return o1.height - o2.height;
            }
        };

        Collections.sort(soldiers, new CustomizedComparator<>(nameComporator, heightComporator));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name + " " + soldier.height);
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
    }

    public static class Soldier {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

    }
}






























