package com.javarush.task.task24.task2413;

public class Brick extends BaseObject {

    public Brick(double x, double y) {
        super(x, y, 3);
    }

    //картинка для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    @Override
    public void move() {

    }
}
