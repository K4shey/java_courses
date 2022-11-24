package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/*
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {

    private static AtomicInteger countFiles = new AtomicInteger();
    private static AtomicInteger countDirs = new AtomicInteger(-1);
    private static AtomicLong totalSize = new AtomicLong();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String dirPath = bufferedReader.readLine();
        if (Files.isDirectory(Paths.get(dirPath))) {
            EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
            final Solution solution = new Solution();
            Files.walkFileTree(Paths.get(dirPath + "/"), options, 20, solution);

            System.out.println("Всего папок - " + countDirs);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер -  " + totalSize);
        } else {
            System.out.println(dirPath + " - не папка");
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles.getAndIncrement();
        totalSize.getAndAdd(attrs.size());
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        countDirs.getAndIncrement();
        return super.postVisitDirectory(dir, exc);
    }
}






























