package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/

public class Solution implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new Solution(4));
        File file = File.createTempFile("my_temp_file", null);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream((file));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Solution savedObject = new Solution(5);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution loadedObject = new Solution(6);
        loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(savedObject.toString().equals(loadedObject.toString()));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}






























