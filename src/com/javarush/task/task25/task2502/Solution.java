package com.javarush.task.task25.task2502;

import java.util.*;

/*
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here

            String[] wheelsArray = loadWheelNamesFromDB();
            if (wheelsArray.length != 4) {
                throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>();
            for (String wheel : wheelsArray) {
                wheels.add(Wheel.valueOf(wheel));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}






























