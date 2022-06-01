package com.javarush.task.task23.task2312;

import java.util.List;
import java.awt.event.KeyEvent;

public class Room {

    public static Room game;

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(10, 10);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(20, 20, snake);
        game.createMouse();
        game.run();
    }

    public void run() {

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }
        System.out.println("Game over!");
    }

    public void print() {

        int[][] matrix = new int[height][width];
        List<SnakeSection> sections = snake.getSections();
        for (int i = 0; i < sections.size(); i++) {
            matrix[sections.get(i).getY()][sections.get(i).getX()] = i == 0 ? 2 : 1;
        }
        matrix[mouse.getY()][mouse.getX()] = 3;
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print(".");
                } else if (matrix[i][j] == 1) {
                    System.out.print("#");
                } else if (matrix[i][j] == 2) {
                    System.out.print("@");
                } else if (matrix[i][j] == 3) {
                    System.out.print("&");
                }
            }
            System.out.println();
        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
    }

    public void sleep() {
        long pauseValue = 0;
        if (snake.getSections().size() <= 10) {
            pauseValue = 500 - (snake.getSections().size() - 1) * 20L;
        } else if (snake.getSections().size() >= 11 && snake.getSections().size() < 15) {
            pauseValue = 325 - (snake.getSections().size() % 10) * 25L;
        } else {
            pauseValue = 200L;
        }
        try {
            Thread.sleep(pauseValue);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        mouse = new Mouse(x, y);
    }

    public void eatMouse() {
        createMouse();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
