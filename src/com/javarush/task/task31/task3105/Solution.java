package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.exit(0);
        }
        String fileName = args[0];
        String zipFileName = args[1];
        Map<String, ByteArrayOutputStream> mapZipFile = new TreeMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName));) {
            ZipEntry zipEntry = null;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                int len = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int bufferSize = 4 * 1024;
                byte[] buffer = new byte[bufferSize];
                while ((len = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                mapZipFile.put(zipEntry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));) {

            String newFileName = "new/" + Paths.get(fileName).getFileName();
            zipOutputStream.putNextEntry(new ZipEntry(newFileName));
            Files.copy(new File(fileName).toPath(), zipOutputStream);
            zipOutputStream.closeEntry();

            for (Map.Entry<String, ByteArrayOutputStream> entry : mapZipFile.entrySet()) {
                if (mapZipFile.containsKey(newFileName) && newFileName.equals(entry.getKey())) {
                    continue;
                }
                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                zipOutputStream.write(entry.getValue().toByteArray());
                zipOutputStream.closeEntry();
            }

        }
    }
}