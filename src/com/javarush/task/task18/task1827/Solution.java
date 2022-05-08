package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].equals("-c")) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        int fileId = getLastId(filename);
        fileId++;
        FileWriter fileWriter = new FileWriter(filename, true);
        String result = String.format("\n%-8d%-30s%-8s%-4s", fileId, args[1], args[2], args[3]);
        fileWriter.write(result);
        fileWriter.close();

    }

    public static int getLastId(String filename) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String nextLine = "";
        int maxId = 0;
        while (bufferedReader.ready()) {
            nextLine = bufferedReader.readLine();
            int currentId = Integer.parseInt(nextLine.substring(0, 8).trim());
            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        bufferedReader.close();
        return maxId;
    }
}
