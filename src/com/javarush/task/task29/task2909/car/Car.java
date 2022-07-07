package com.javarush.task.task29.task2909.car;

import java.util.Date;

abstract public class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {

        Car car = null;
        if (type == TRUCK) {
            car = new Truck(numberOfPassengers);
        }
        if (type == SEDAN) {
            car = new Sedan(numberOfPassengers);
        }
        if (type == CABRIOLET) {
            car = new Cabriolet(numberOfPassengers);
        }
        return car;
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0) {
            throw new IllegalArgumentException();
        }
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return (!(date.before(summerStart) || date.after(summerEnd)));
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        double consumption;
        if (isSummer(date, summerStart, summerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }

    public int getNumberOfPassengersCanBeTransferred() {

        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        } else {
            return 0;
        }
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {

        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    abstract public int getMaxSpeed();
}





























