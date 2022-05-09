package com.javarush.task.task18.task1822;

import java.io.*;

/*
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String id = args[0];
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String lineId = nextLine.substring(0, nextLine.indexOf(" "));
            if (lineId.equals(id)) {
                System.out.println(nextLine);
            }
        }
        bufferedReader.close();
    }
}






























