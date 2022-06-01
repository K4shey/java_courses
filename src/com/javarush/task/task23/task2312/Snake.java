package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public void checkBorders(SnakeSection head) {
        if (head.getX() >= Room.game.getWidth()
                || head.getX() < 0
                || head.getY() >= Room.game.getHeight()
                || head.getY() < 0) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        List<SnakeSection> sections = getSections();
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    public void move() {
        if (!isAlive()) {
            return;
        }
        if (direction == SnakeDirection.UP) {
            move(0, -1);
        } else if (direction == SnakeDirection.RIGHT) {
            move(1, 0);
        } else if (direction == SnakeDirection.DOWN) {
            move(0, 1);
        } else if (direction == SnakeDirection.LEFT) {
            move(-1, 0);
        }
    }

    public void move(int dx, int dy) {

        SnakeSection previousPositionHead = sections.get(0);
        int newX = previousPositionHead.getX() + dx;
        int newY = previousPositionHead.getY() + dy;
        SnakeSection newPositionHead = new SnakeSection(newX, newY);
        checkBorders(newPositionHead);
        if (!isAlive()) {
            return;
        }
        checkBody(newPositionHead);
        if (!isAlive()) {
            return;
        }

        sections.add(0, newPositionHead);
        Mouse mouse = Room.game.getMouse();
        if (newX == mouse.getX() && newY == mouse.getY() ) {
            Room.game.eatMouse();
        } else {
            sections.remove(sections.size()-1);
        }

    }


    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
