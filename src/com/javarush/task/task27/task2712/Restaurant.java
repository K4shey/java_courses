package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Chef Ivlev");
        tablet.addObserver(cook);
        tablet.createOrder();
    }

}





























