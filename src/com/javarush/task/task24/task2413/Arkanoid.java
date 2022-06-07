package com.javarush.task.task24.task2413;

import java.util.Iterator;
import java.util.List;

public class Arkanoid {

    private int height;
    private int width;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    public static Arkanoid game;
    private boolean isGameOver;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void run() {

    }

    public void draw(Canvas canvas) {
        stand.draw(canvas);
        ball.draw(canvas);
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }

    public void move() {
        ball.move();
        stand.move();
    }

    public void checkBricksBump() {
        Iterator<Brick> iterator = bricks.iterator();
        while (iterator.hasNext()) {
            if (ball.intersects(iterator.next())) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                iterator.remove();
            }
        }
    }

    public void checkStandBump() {
        if (ball.intersects(stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    public void checkEndGame() {
        if (ball.getY() > height) {
            this.isGameOver = true;
        }
    }

    public static void main(String[] args) {

    }
}
