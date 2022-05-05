package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String filename1 = bufferedReader.readLine();
            String filename2 = bufferedReader.readLine();
            BufferedReader objectReader1 = new BufferedReader(new FileReader(filename1));
            while (objectReader1.ready()) {
                allLines.add(objectReader1.readLine());
            }
            BufferedReader objectReader2 = new BufferedReader(new FileReader(filename2));
            while (objectReader2.ready()) {
                forRemoveLines.add(objectReader2.readLine());
            }
            objectReader1.close();
            objectReader2.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong " + e);
        }
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException cde) {
            System.out.println("Something went wrong " + cde);
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}






























