package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;

import java.io.IOException;

public class ExitCommand implements Command {

    public void execute() throws IOException {
        ConsoleHelper.writeMessage("До встречи!");
    }

}
