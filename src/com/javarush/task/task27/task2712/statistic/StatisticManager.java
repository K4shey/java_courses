package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticManager.StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);

    }

    public void register(Cook cook) {
        this.cooks.add(cook);
    }

    public void getAdvertisementProfit() {
        Map<EventType, List<EventDataRow>> events = statisticStorage.getStorage();
        Map<String, Double> tmpMap = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);

        for (EventDataRow event : events.get(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) event;
            String nextDay = simpleDateFormat.format(dataRow.getDate());
            double info = dataRow.getAmount() / 100.0;
            if (!tmpMap.containsKey(nextDay)) {
                tmpMap.put(nextDay, 0.0);
            }
            tmpMap.put(nextDay, tmpMap.get(nextDay) + info);
        }
        double sumTotal = 0.0;
        for (Map.Entry<String, Double> element : tmpMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %.2f", element.getKey(), element.getValue()));
            sumTotal += element.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", sumTotal));
    }

    public void getCookWorkloading() {

        Map<EventType, List<EventDataRow>> events = statisticStorage.getStorage();
        Map<String, Map<String, Integer>> dailyCookTime = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
        for (EventDataRow event : events.get(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow dataRow = (CookedOrderEventDataRow) event;
            String nextDay = simpleDateFormat.format(event.getDate());
            if (!dailyCookTime.containsKey(nextDay)) {
                dailyCookTime.put(nextDay, new TreeMap<>());
            }
            Map<String, Integer> tmpMap = dailyCookTime.get(nextDay);
            if (!tmpMap.containsKey(dataRow.getCookName())) {
                tmpMap.put(dataRow.getCookName(), 0);
            }
            tmpMap.put(dataRow.getCookName(), tmpMap.get(dataRow.getCookName()) + (int) Math.ceil(dataRow.getTime() / 60.0));
        }

        for (Map.Entry<String, Map<String, Integer>> element : dailyCookTime.entrySet()) {
            ConsoleHelper.writeMessage(element.getKey());
            for (Map.Entry<String, Integer> info : element.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", info.getKey(), info.getValue()));
            }
        }
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType element : EventType.values()) {
                storage.put(element, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            this.storage.get(data.getEventType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

    }
}
