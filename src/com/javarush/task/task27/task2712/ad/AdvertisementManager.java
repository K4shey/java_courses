package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    private List<Advertisement> bestSet = new ArrayList<>();
    private int bestValue = 0;
    private int bestDuration = 0;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> tmpList = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getHits() > 0 && ad.getDuration() <= timeSeconds) {
                tmpList.add(ad);
            }
        }
        makeAllSets(tmpList);

//        Collections.sort(bestSet, new Comparator<Advertisement>() {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2) {
//                Long amountPerOneDisplaying1 =  o1.getAmountPerOneDisplaying();
//                Long amountPerOneDisplaying2 =  o2.getAmountPerOneDisplaying();
//                if (amountPerOneDisplaying1.equals(amountPerOneDisplaying2)) {
//                    Long amountPerSecond1 = amountPerOneDisplaying1 / timeSeconds;
//                    Long amountPerSecond2 = amountPerOneDisplaying2 / timeSeconds;
////                    return (int) ( - (amountPerOneDisplaying2 / timeSeconds));
//                    return amountPerSecond1.compareTo(amountPerSecond2);
//                }
////                return (int) (o1.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
//                return amountPerOneDisplaying2.compareTo(amountPerOneDisplaying1);
//            }
//        });

        Collections.sort(bestSet, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long result = 0;
                long firstAmount = o1.getAmountPerOneDisplaying();
                long secondAmount = o2.getAmountPerOneDisplaying();
                result = secondAmount - firstAmount;
                if (firstAmount == secondAmount) {
                    firstAmount = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    secondAmount = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    result = firstAmount - secondAmount;
                }
                return (int) result;
            }
        });
        EventDataRow event = new VideoSelectedEventDataRow(bestSet, bestValue, bestDuration);
//        EventDataRow event = new VideoSelectedEventDataRow(bestSet, bestValue, bestDuration, new Date());
        StatisticManager.getInstance().register(event);

        for (Advertisement ad : bestSet) {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    ad.getName(), ad.getAmountPerOneDisplaying(), 1000 * ad.getAmountPerOneDisplaying() / ad.getDuration()));
            ad.revalidate();
        }
    }

    public int calcTiming(List<Advertisement> list) {
        int result = 0;
        for (Advertisement advertisement : list) {
            result += advertisement.getDuration();
        }
        return result;
    }

    public int calcValue(List<Advertisement> list) {
        int result = 0;
        for (Advertisement advertisement : list) {
            result += advertisement.getAmountPerOneDisplaying();
        }
        return result;
    }

    public void checkSet(List<Advertisement> list) {
        if (bestSet.isEmpty()) {
            if (calcTiming(list) <= timeSeconds) {
                bestSet = list;
                bestValue = calcValue(list);
                bestDuration = calcTiming(list);
            }
        }  else if (calcTiming(list) <= timeSeconds && calcValue(list) == bestValue) {
            if (calcTiming(list) == bestDuration) {
                if (list.size() < bestSet.size()) {
                    bestSet = list;
                    bestValue = calcValue(list);
                    bestDuration = calcTiming(list);
                }
            } else if  (calcTiming(list) > bestDuration) {
                bestSet = list;
                bestValue = calcValue(list);
                bestDuration = calcTiming(list);
            }
        } else if (calcTiming(list) <= timeSeconds && calcValue(list) > bestValue) {
            bestSet = list;
            bestValue = calcValue(list);
            bestDuration = calcTiming(list);
        }
    }

    public void makeAllSets(List<Advertisement> list) {

        if (list.size() > 0) {
            checkSet(list);
        }
        for (int i = 0; i < list.size(); i++) {
            List<Advertisement> nextSet = new ArrayList<>(list);
            nextSet.remove(i);
            if (calcValue(nextSet) >= bestValue) {
                makeAllSets(nextSet);
            }
        }
    }
}
