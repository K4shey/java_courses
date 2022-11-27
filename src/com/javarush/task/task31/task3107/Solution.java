package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) throws IOException {
        try {
            Path path = Paths.get(pathToFile);
            boolean isHidden = Files.isHidden(path);
            boolean isExecutable = Files.isExecutable(path);
            boolean isDirectory = Files.isDirectory(path);
            boolean isWritable = Files.isWritable(path);

            this.fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);

        } catch (IOException ioe) {

            this.fileData = new NullFileData(ioe);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}





























