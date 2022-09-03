package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

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