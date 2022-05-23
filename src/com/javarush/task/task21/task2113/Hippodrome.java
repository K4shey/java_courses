package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) {

        List<Horse> listHorses = new ArrayList<>();
        listHorses.add(new Horse("Sivka", 3, 0));
        listHorses.add(new Horse("Burka", 3, 0));
        listHorses.add(new Horse("Gorbunok", 3, 0));
        game = new Hippodrome(listHorses);
        game.run();
        game.printWinner();

    }

    public Hippodrome(List<Horse> horses) {
        if (horses != null) {
            this.horses = horses;
        }
    }

    public List getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {

            }
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        String text = String.format("Winner is %s!", getWinner().getName());
        System.out.println(text);
    }

}
