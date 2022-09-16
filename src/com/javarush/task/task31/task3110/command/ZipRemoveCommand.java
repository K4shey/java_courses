package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Удаление файла из архива");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите имя файла для удаления из архива");
            String fullPathOutputFolder = ConsoleHelper.readString();
            zipFileManager.removeFile(Paths.get(fullPathOutputFolder));
            ConsoleHelper.writeMessage("Удаление закончено");
        } catch (WrongZipFileException wrongZipFileException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя архива.");
        }
    }
}
