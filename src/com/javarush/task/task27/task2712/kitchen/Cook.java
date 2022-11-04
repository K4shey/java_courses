package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void update(Observable o, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        Order tmp_order = (Order) order;
        EventDataRow event = new CookedOrderEventDataRow(
                tmp_order.getTablet().toString(),
                name,
                tmp_order.getTotalCookingTime(),
                tmp_order.getDishes());
        StatisticManager.getInstance().register(event);
    }
}
