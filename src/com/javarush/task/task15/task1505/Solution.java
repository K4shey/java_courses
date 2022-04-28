package com.javarush.task.task15.task1505;

/*
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public interface HasWeight {
        int getWeight();
    }

    public interface HasHeight {
        int getHeight();
    }

    public static class Human implements HasWeight, HasHeight {
        //        @Override
//        public int getValue() {
//            return 0;
//        }
        @Override
        public int getHeight() {
            return 182;
        }

        @Override
        public int getWeight() {
            return 89;
        }

    }

    public static void main(String[] args) {
        Human human = new Human();
//        System.out.println(human.getValue());
//        System.out.println(human.getValue());
        System.out.println(human.getHeight());
        System.out.println(human.getWeight());
    }
}





























