package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        writeMessage("Please, enter name of dish to add it to order, or 'exit':");
        String nextLine = readString();
        while (!nextLine.equals("exit")) {
            boolean DishNotExist = true;
            for (Dish nextDish : Dish.values()) {
                if (nextDish.name().equals(nextLine)) {
                    order.add(nextDish);
                    DishNotExist = false;
                }
            }
            if (DishNotExist) {
                writeMessage("This dish is not on our menu.");
            }
            writeMessage("Please, enter name of dish to add it to order, or 'exit':");
            nextLine = readString();
        }
        return order;
    }
}
