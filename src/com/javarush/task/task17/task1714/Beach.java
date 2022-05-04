package com.javarush.task.task17.task1714;

/*
Comparable
*/

import java.util.*;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

//        List<Beach> list = new ArrayList<>();
//        list.add(new Beach("San Francisco beach", 6.0f, 8));
//        list.add(new Beach("Florida beach", 10.0f, 5));
//        list.add(new Beach("California beach", 20.0f, 8));
//        list.add(new Beach("Miami beach", 20.0f, 5));
//        Collections.sort(list);
//        System.out.println(list.toString());

        Beach b1 = new Beach("1", 100, 4);
        Beach b2 = new Beach("2", 100, 3);
        System.out.println(b1.compareTo(b2));

    }

    @Override
    public String toString() {
        return "Beach{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", quality=" + quality +
                '}';
    }

    @Override
    public synchronized int compareTo(Beach o) {

        int qualityPoint = 0;
        int distancePoint = 0;
        int qualityCompare = getQuality() - o.getQuality();
        if (qualityCompare != 0) {
            qualityPoint = qualityCompare > 0 ? 1 : -1;
        }
        float distanceCompare = getDistance() - o.getDistance();
        if (distanceCompare != 0.0f) {
            distancePoint = distanceCompare < 0.0f ? 1 : -1;
        }
        return qualityPoint + distancePoint;
    }
}






























