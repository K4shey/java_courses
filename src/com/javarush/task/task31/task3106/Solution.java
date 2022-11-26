package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.exit(0);
        }

        String resultFileName = args[0];
        Set<String> filesSet = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            filesSet.add(args[i]);
        }

        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (String nextFileName : filesSet) {
            fileInputStreams.add(new FileInputStream(nextFileName));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)));
             FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
        ) {
            int len = 0;
            while (zipInputStream.available() > 0) {
                zipInputStream.getNextEntry();
                int bufferSize = 4 * 1024;
                byte[] buffer = new byte[bufferSize];
                while ((len = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, len);
                }
                fileOutputStream.close();
            }
        }

    }
}
