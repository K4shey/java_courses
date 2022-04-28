package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            if (line.equals("helicopter")) {
                result = new Helicopter();
            } else if (line.equals("plane")){
                int counter = Integer.parseInt(bufferedReader.readLine());
                result = new Plane(counter);
            }
            bufferedReader.close();
        } catch (IOException e){
            System.out.println("Something went wrong " + e);
        }
    }
}






























