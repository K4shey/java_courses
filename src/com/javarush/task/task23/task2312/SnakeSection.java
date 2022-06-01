package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private  int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SnakeSection that = (SnakeSection) obj;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }
}
