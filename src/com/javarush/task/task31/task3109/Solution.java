package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/*
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("d:/Downloads/task_3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("d:/Downloads/task_3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("d:/Downloads/task_3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException fnf) {
            return properties;
        }

        try {
            InputStream inputStream = new FileInputStream(fileName);
            properties.loadFromXML(inputStream);
            return properties;
        } catch (InvalidPropertiesFormatException e) {
            try {
                InputStream inputStream = new FileInputStream(fileName);
                properties.load(inputStream);
                return properties;
            } catch (IOException ioException) {
                return properties;
            }
        } catch (IOException ioException) {
            return properties;
        }
    }
}






























