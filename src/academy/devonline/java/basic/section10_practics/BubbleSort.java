package academy.devonline.java.basic.section10_practics;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] source = {3, 7, 1, 9, 4, 8, 5, 2, 6};
        System.out.println("Исходный:");
        System.out.println(Arrays.toString(source));
        BubbleSort(source);
        System.out.println("Конечный:");
        System.out.println(Arrays.toString(source));
    }
//    private static int[] BubbleSort(int[] source) {
      private static void BubbleSort(int[] source) {
        int endIndex = source.length;
        while (endIndex >= 0) {
            for (int i = 0; i < endIndex - 1; i++) {
                if (source[i] > source[i + 1]) {
                    int temp = source[i];
                    source[i] = source[i + 1];
                    source[i + 1] = temp;
                }
            }
            endIndex--;
        }
//        return source;
    }
}
