package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean containsName = false;
        if (partOfName == null) {
            containsName = true;
        } else if (file.getFileName().toString().contains(partOfName)) {
            containsName = true;
        }

        boolean containsContent = false;
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (partOfContent == null) {
            containsContent = true;
        } else if (new String(content).contains(partOfContent)) {
            containsContent = true;
        }

        boolean moreMinSize = false;
        if (minSize == 0) {
            moreMinSize = true;
        } else if (content.length > minSize) {
            moreMinSize = true;
        }

        boolean lessMaxSize = false;
        if (maxSize == 0) {
            lessMaxSize = true;
        } else if (content.length < maxSize) {
            lessMaxSize = true;
        }

        if (containsName && containsContent && moreMinSize && lessMaxSize) {
            foundFiles.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

}






























