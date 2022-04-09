package com.javarush.task.pro.task10.task1016;

/*
Прогноз погоды
*/

public class Solution {

    public static void showWeather(City city) {
        String message = new String("В городе %s сегодня температура воздуха %d");
        System.out.println(String.format(message, city.getName(), city.getTemperature()));
    }

    public static void main(String[] args) {
        City city = new City("Амстердам", 21);
        showWeather(city);
    }
}






























