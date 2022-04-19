package com.javarush.task.pro.task15.task1522;

import java.io.*;
import java.net.URL;

/*
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        try (InputStream inputStream = url.openStream();) {
            byte[] array = inputStream.readAllBytes();
            System.out.println((new String(array)));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}





























