package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {

        try {
        ConsoleHelper.writeMessage("Создание архива");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите полный путь к объекту архивирования");
        String fullPathArchive = ConsoleHelper.readString();
        zipFileManager.createZip(Paths.get(fullPathArchive));
        ConsoleHelper.writeMessage("Архив создан");
        } catch (PathIsNotFoundException pathIsNotFoundException) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }

    }

}
