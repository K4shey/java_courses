package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 5;
    }

    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.",
                super.getDescription(), Country.RUSSIA, getCountOfEggsPerMonth());
    }
}
