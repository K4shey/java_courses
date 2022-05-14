package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/*
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, "test properties");
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        Set enumKeys = properties.keySet();
        Iterator iterator = enumKeys.iterator();
        while (iterator.hasNext()) {
            String nextKey = (String) iterator.next();
            runtimeStorage.put(nextKey, properties.getProperty(nextKey));
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("d:\\Downloads\\unloaded.properties");
            save(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






























