package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter path to Zip file:");
        String pathToZip = bufferedReader.readLine();
        System.out.println("Enter path to file to archive:");
        String pathToFile = bufferedReader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathToZip));
        zipFileManager.createZip(Paths.get(pathToFile));
        new ExitCommand().execute();
    }
}
