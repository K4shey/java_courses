package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        File[] files = new File(root).listFiles();
        for (File f : files) {
            queue.add(f);
        }

        while (queue.size() > 0) {
            File tmp = queue.poll();
            if (tmp.isDirectory()) {
                queue.addAll(Arrays.asList(tmp.listFiles()));
            } else if (tmp.isFile()) {
                result.add(tmp.getAbsolutePath());
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("d:\\Downloads\\task_3101\\source");
        for (String path : list) {
            System.out.println(path);
        }
    }
}






























