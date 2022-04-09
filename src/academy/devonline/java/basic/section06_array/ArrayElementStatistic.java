package academy.devonline.java.basic.section06_array;

import java.util.Arrays;

public class ArrayElementStatistic {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 4, 4, 3, 3, 2, 2, 2, 2, 2};
        double coefficient = 100.0 / array.length;
        int[] quantity = new int[array.length];
        int[] values = new int[array.length];
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            int num = 0;
            int value = array[i];
            boolean numberInArray = false;
            for (int element : values
            ) {
                if (element == value) {
                    numberInArray = true;
                    break;
                }
            }
            if (numberInArray) {
                continue;
            }
            counter++;
            for (int j = i; j < array.length; j++) {
                if (array[j] == value) {
                    num++;
                }
            }
            values[i] = value;
            quantity[i] = num;
        }
        for (int i = 0; i < counter; i++) {
            int currentValue = values[i];
            double currentQuantity = quantity[i];
            double percent = coefficient * currentQuantity;
            System.out.println("" + currentValue + "=" + percent + "%");
        }
    }
}
