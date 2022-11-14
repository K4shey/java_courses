package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

//        String path = "d:/Downloads/task_3101/source";
//        String resultFileAbsolutePath = "d:/Downloads/task_3101/content.txt";
        if (args.length == 0) {
            System.exit(0);
        }
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File oldNameFile = new File(resultFileAbsolutePath);
        String newFilename = oldNameFile.getParent() + "/" + "allFilesContent.txt";
        File newNameFile = new File(newFilename);
        if (FileUtils.isExist(newNameFile)) {
            FileUtils.deleteFile(newNameFile);
        }
        FileUtils.renameFile(oldNameFile, newNameFile);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = new FileOutputStream(newFilename, true);
        try {
            List<File> listFiles = getListFiles(path);
            for (File nextFile : listFiles) {
                if (nextFile.isDirectory()) {
                    continue;
                }
                if (nextFile.length() > 50) {
                    continue;
                }
                fileInputStream = new FileInputStream(nextFile);
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                }
                fileInputStream.close();
                fileOutputStream.write('\n');
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            fileOutputStream.close();
        }
    }

    public static List<File> getListFiles(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        List<File> result = new ArrayList<>();
        result.addAll(Arrays.asList(files));
        for (File f : files) {
            if (f.isFile()) {
            } else if (f.isDirectory()) {
                result.addAll(getListFiles(f.getAbsolutePath()));
            }
        }
        return result;
    }
}






























