package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString(){
        if (dishes == null || dishes.size() == 0)
            return "";
        StringBuilder result = new StringBuilder("Your order: ");
        result.append(dishes.toString()).append(" of ");
        result.append(tablet.toString());
        return result.toString();
    }

}
