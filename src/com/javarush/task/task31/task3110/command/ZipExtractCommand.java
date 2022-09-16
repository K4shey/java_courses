package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите полный путь к директории, в которую нужно распаковать архив");
            String fullPathOutputFolder = ConsoleHelper.readString();
            zipFileManager.extractAll(Paths.get(fullPathOutputFolder));
            ConsoleHelper.writeMessage("Архив распакован");
        } catch (PathIsNotFoundException pathIsNotFoundException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        } catch (WrongZipFileException wrongZipFileException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя архива.");
        }
    }
}
