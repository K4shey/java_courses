package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    public int getDuration() {
        return duration;
    }

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Dish.values().length; i++) {
            result.append(Dish.values()[i].toString());
            if (i < Dish.values().length - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}