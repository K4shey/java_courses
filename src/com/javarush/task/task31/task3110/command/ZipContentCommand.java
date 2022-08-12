package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();
        for (FileProperties property : filePropertiesList) {
            ConsoleHelper.writeMessage(property.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
