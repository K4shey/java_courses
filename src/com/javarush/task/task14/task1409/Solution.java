package com.javarush.task.task14.task1409;

/*
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    public static void println (Bridge bridge){
        int count = 0;
        if (bridge instanceof SuspensionBridge) {
            SuspensionBridge suspensionBridge = (SuspensionBridge) bridge;
            count = suspensionBridge.getCarsCount();
        } else if (bridge instanceof WaterBridge) {
            WaterBridge waterBridge = (WaterBridge) bridge;
            count = waterBridge.getCarsCount();
        }
        System.out.println(count);
    }
}































