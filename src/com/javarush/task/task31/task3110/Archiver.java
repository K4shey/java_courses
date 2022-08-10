package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        Operation operation = null;
        while (operation != Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException wrongZipFileException) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
                continue;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
                continue;
            }
        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - Упаковать файлы в архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - Добавить файл в архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - Удалить файл из архива");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - Распаковать файлы из архива");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - Просмотреть содержимое архива");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - Выход");
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
