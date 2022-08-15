package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление файла в архив");
            ZipFileManager zipFileManager = getZipFileManager();
            ConsoleHelper.writeMessage("Введите имя файла для добавления в архив");
            String fullPathOutputFolder = ConsoleHelper.readString();
            zipFileManager.addFile(Paths.get(fullPathOutputFolder));
            ConsoleHelper.writeMessage("Добавление закончено");
        } catch (WrongZipFileException wrongZipFileException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя архива.");
        } catch (PathIsNotFoundException pathIsNotFoundException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
