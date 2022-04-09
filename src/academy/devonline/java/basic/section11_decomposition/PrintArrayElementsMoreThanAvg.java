package academy.devonline.java.basic.section11_decomposition;

import java.util.Arrays;

public class PrintArrayElementsMoreThanAvg {
    public static void main(String[] args) {
        int[] array = {1, 4, -5, -2, 0, 12, 13};
        int average = calculateAverageOFArray(array);
        System.out.println(Arrays.toString(findElementsMoreThan(average, array)));
    }

    private static int calculateAverageOFArray(int[] array) {
        int average = 0;
        double sum = getSum(array);
        average = round( sum / array.length);
//        System.out.println(average);
        return average;
    }

    private static double getSum(int[] array) {
        double sum = 0.0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    private static int round(double value) {
        return (int) (value + 0.5);
    }

    private static int[] findElementsMoreThan(int average, int[] array) {
        int[] destArray = new int[array.length];
        int sizeOfResultArray = 0;

        for (int element : array) {
            if (element > average) {
//                destArray[sizeOfResultArray] = element;
//                sizeOfResultArray++;
                destArray[sizeOfResultArray++] = element;
            }
        }
        if (destArray.length > sizeOfResultArray) {
            return CopyArray(destArray, sizeOfResultArray);
        } else {
            return destArray;
        }
    }

    private static int[] CopyArray(int[] array, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
