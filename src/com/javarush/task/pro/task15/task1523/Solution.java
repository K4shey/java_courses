package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/*
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        try (OutputStream outputStream = urlConnection.getOutputStream()){
            PrintStream printStream = new PrintStream(outputStream);
            printStream.print(2);
        } catch (Exception e){
            System.out.println("Something wen wrong " + e);
        }
        try (InputStream inputStream = urlConnection.getInputStream()){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()) {
                String result = bufferedReader.readLine();
                System.out.println(result);
            }
        }  catch (Exception e){
            System.out.println("Something wen wrong " + e);
        }
    }
}































