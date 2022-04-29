package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String parameters = url.substring(url.indexOf("?") + 1, url.length());
//        String[] array = parameters.split("&|=");
//        List<String> listOfObj = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            String parameter = array[i++];
//            System.out.print(parameter + " ");
//            if (parameter.equals("obj")) {
//                listOfObj.add(array[i]);
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < listOfObj.size(); i++) {
//            try {
//                alert(Double.parseDouble(listOfObj.get(i)));
//            } catch(NumberFormatException e){
//            alert(listOfObj.get(i));
//        }
//    }
//        reader.close();

        String[] array = parameters.split("&");
        List<String> listOfObj = new ArrayList<>();
        for (String element : array) {
            String[] innerArray = element.split("=");
            System.out.println(innerArray[0] + " ");
            if (innerArray[0].equals("obj")) {
                listOfObj.add(innerArray[1]);
            }
        }
        for (String nextObject : listOfObj) {
            try {
                alert(Double.parseDouble(nextObject));
            } catch (NumberFormatException e) {
                alert(nextObject);
            }
        }

        reader.close();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}






























