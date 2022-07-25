package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class BotClient extends Client {
    @Override
    protected String getUserName() {
        int number = (int) (Math.random() * 100);
        return "date_bot_" + number;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(":")) {
                String[] stringsArray = message.split(":");
                if (stringsArray.length != 2) {
                    return;
                }
                String userName = stringsArray[0].trim();
                String request = stringsArray[1].trim();
                String template = "";
                switch (request) {
                    case "дата":
                        template = "d.MM.YYYY";
                        break;
                    case "день":
                        template = "d";
                        break;
                    case "месяц":
                        template = "MMMM";
                        break;
                    case "год":
                        template = "YYYY";
                        break;
                    case "время":
                        template = "H:mm:ss";
                        break;
                    case "час":
                        template = "H";
                        break;
                    case "минуты":
                        template = "m";
                        break;
                    case "секунды":
                        template = "s";
                        break;
                    default: return;
                }

                SimpleDateFormat formatter = new SimpleDateFormat(template);
                Calendar calendar = new GregorianCalendar();
                String result = "Информация для " + userName + ": " + formatter.format(calendar.getTime());
                sendTextMessage(result);
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            try {
                BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
                super.clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
