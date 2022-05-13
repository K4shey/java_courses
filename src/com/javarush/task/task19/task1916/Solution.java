package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
//        String filename1 = "d:\\Downloads\\file1.txt";
//        String filename2 = "d:\\Downloads\\file2.txt";
        bufferedReader.close();

        BufferedReader bufferedReaderOriginal = new BufferedReader(new FileReader(filename1));
        BufferedReader bufferedReaderEdited = new BufferedReader(new FileReader(filename2));
        List<String> originalList = new ArrayList<>();
        List<String> editedList = new ArrayList<>();

        while (bufferedReaderOriginal.ready()) {
            originalList.add(bufferedReaderOriginal.readLine());
        }
        while (bufferedReaderEdited.ready()) {
            editedList.add(bufferedReaderEdited.readLine());
        }
        int i = 0;
        int j = 0;
//        int count = Math.max(originalList.size(), editedList.size());
        while (i < originalList.size() && j < editedList.size()) {
            if (originalList.get(i).equals(editedList.get(j))) {
                lines.add(new LineItem(Type.SAME, editedList.get(j)));
                    i++;
                    j++;
            } else if (editedList.get(j).equals(originalList.get(i + 1))) {
                lines.add(new LineItem(Type.REMOVED, originalList.get(i)));
                    i++;
            } else if (editedList.get(j + 1).equals(originalList.get(i))) {
                lines.add(new LineItem(Type.ADDED, editedList.get(j)));
                    j++;
            }
        }

        while (i < (originalList.size())) {
            lines.add(new LineItem(Type.REMOVED, originalList.get(i)));
            i++;
        }
        while (j < (editedList.size())) {
            lines.add(new LineItem(Type.ADDED, editedList.get(j)));
            j++;
        }
        bufferedReaderEdited.close();
        bufferedReaderOriginal.close();
//        for (LineItem line : lines) {
//            System.out.println(line.line + " " + line.type);
//
//        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}






























