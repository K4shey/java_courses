package academy.devonline.java.basic.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] gameField = {
                {'7', '8', '9' },
                {'4', '5', '6' },
                {'1', '2', '3' }
        };
        boolean compWin = false;
        boolean userWin = false;
        boolean draw = false;
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        displayField(gameField);
        System.out.println("Let's start!");
        clearField(gameField);
        while (true) {
            displayField(gameField);
            makeUsersMove(gameField);
            if (isLineFilledByChar(gameField, 'X')) {
                displayField(gameField);
                System.out.println("YOU WIN!");
                break;
            } else if (isDraw(gameField)) {
                displayField(gameField);
                System.out.println("Sorry, DRAW!");
                break;
            }
            displayField(gameField);
            makeComputersMove(gameField);
            if (isLineFilledByChar(gameField, '0')) {
                displayField(gameField);
                System.out.println("COMPUTER WIN!");
                break;
            } else if (isDraw(gameField)) {
                displayField(gameField);
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");
    }

    private static void makeUsersMove(char[][] gameField) {
        boolean finish = false;
        int pos = 0;
        while (!finish) {
            System.out.println("Enter your move, please:");
            String move = new Scanner(System.in).nextLine();
            if (move.length() == 1) {
                if (move.charAt(0) >= '0' && move.charAt(0) <= '9') {
                    pos = Integer.parseInt(move);
                    if (moveIsCorrect(pos, gameField)) {
                        finish = true;
                    } else {
                        System.out.println("This position is not empty!");
                    }
                }
            }
        }
        setValueByPos(pos, gameField, 'X');
    }

    private static void makeComputersMove(char[][] gameField) {
//        int pos = new Random().nextInt(8) + 1;
        int pos = checkLastChar(gameField, '0');
        while (!moveIsCorrect(pos, gameField)) {
//            pos = new Random().nextInt(8) + 1;
            pos = checkLastChar(gameField, '0');
            if (pos == 0) {
                pos = checkLastChar(gameField, 'X');
            }
            if (pos == 0) {
                pos = new Random().nextInt(8) + 1;
            }
        }
        setValueByPos(pos, gameField, '0');
    }

    private static int checkLastChar(char[][] gameField, char symbol) {
        char[][] keyMapping = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        for (int i = 0; i < gameField.length; i++) {
            if (gameField[i][0] == symbol && gameField[i][1] == symbol && gameField[i][2] == ' ') {
                return keyMapping[i][2];
            }
            if (gameField[i][1] == symbol && gameField[i][2] == symbol && gameField[i][0] == ' ') {
                return keyMapping[i][0];
            }
            if (gameField[i][0] == symbol && gameField[i][2] == symbol && gameField[i][1] == ' ') {
                return keyMapping[i][1];
            }
            if (gameField[0][i] == symbol && gameField[1][i] == symbol && gameField[2][i] == ' ') {
                return keyMapping[2][i];
            }
            if (gameField[1][i] == symbol && gameField[2][i] == symbol && gameField[0][i] == ' ') {
                return keyMapping[0][i];
            }
            if (gameField[0][i] == symbol && gameField[2][i] == symbol && gameField[1][i] == ' ') {
                return keyMapping[1][i];
            }
        }

        if (gameField[0][0] == symbol && gameField[1][1] == symbol && gameField[2][2] == ' ') {
            return keyMapping[2][2];
        }
        if (gameField[1][1] == symbol && gameField[2][2] == symbol && gameField[0][0] == ' ') {
            return keyMapping[0][0];
        }
        if (gameField[0][0] == symbol && gameField[2][0] == symbol && gameField[1][1] == ' ') {
            return keyMapping[1][1];
        }

        if (gameField[0][2] == symbol && gameField[1][1] == symbol && gameField[2][0] == ' ') {
            return keyMapping[2][0];
        }
        if (gameField[1][1] == symbol && gameField[2][0] == symbol && gameField[0][2] == ' ') {
            return keyMapping[0][2];
        }
        if (gameField[0][2] == symbol && gameField[2][0] == symbol && gameField[1][1] == ' ') {
            return keyMapping[1][1];
        }
        return 0;
    }

    private static void displayField(char[][] gameField) {

        displayVerticalLine(gameField[0].length);
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                System.out.print("| " + gameField[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
            displayVerticalLine(gameField[0].length);
        }
    }

    private static void displayVerticalLine(int size) {
        System.out.print("-");
        for (int i = 0; i < size; i++) {
            System.out.print("----");
        }
        System.out.println();
    }

    private static void clearField(char[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    private static boolean moveIsCorrect(int pos, char[][] gameField) {
        boolean result = true;
        if (pos == 0) {
            return false;
        }
        char value = getValueByPos(pos, gameField);
        if (value != ' ') {
            return false;
        }
        return true;
    }

    private static char getValueByPos(int pos, char[][] gameField) {
        char[][] keyMapping = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (pos == keyMapping[i][j]) {
                    return gameField[i][j];
                }
            }
        }
        return ' ';
    }

    private static void setValueByPos(int pos, char[][] gameField, char value) {
        char[][] keyMapping = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (pos == keyMapping[i][j]) {
                    gameField[i][j] = value;
                }
            }
        }
    }

    private static boolean isLineFilledByChar(char[][] gameField, char symbol) {
        if (checkHorizontal(gameField, symbol)) {
            return true;
        }
        if (checkVertical(gameField, symbol)) {
            return true;
        }
        if (checkDiagonal(gameField, symbol)) {
            return true;
        }
        return false;
    }

    private static boolean checkHorizontal(char[][] gameField, char symbol) {
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (gameField[i][j] == symbol) {
                    counter++;
                }
            }
            if (counter == gameField.length) {
                return true;
            }
            counter = 0;
        }
        return false;
    }

    private static boolean checkVertical(char[][] gameField, char symbol) {
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (gameField[j][i] == symbol) {
                    counter++;
                }
            }
            if (counter == gameField.length) {
                return true;
            }
            counter = 0;
        }
        return false;
    }

    private static boolean checkDiagonal(char[][] gameField, char symbol) {
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            if (gameField[i][i] == symbol) {
                counter++;
            }
        }
        if (counter == gameField.length) {
            return true;
        }
        counter = 0;
        int j = gameField.length - 1;
        for (int i = 0; i < gameField.length; i++) {
            if (gameField[i][j] == symbol) {
                counter++;
            }
            j--;
        }
        if (counter == gameField.length) {
            return true;
        }
        return false;
    }

    private static boolean isDraw(char[][] gameField) {
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (gameField[i][j] != ' ') {
                    counter++;
                }
            }
        }
        if (counter == gameField.length * gameField.length) {
            return true;
        }
        return false;
    }
}
