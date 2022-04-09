package academy.devonline.java.basic.section06_array;

import java.util.Arrays;

public class SwapMinAndMaxArrayElement {
    public static void main(String[] args) {
        int [] source = {1, -2, 3, 8, 5};
        int [] dest = new int [source.length];
        int min = source[0];
        int max = source[0];
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 1; i < source.length ; i++) {
            if (source[i] < min ){
                min = source[i];
                indexMin = i;
            }
            if (source[i] > max ){
                max = source[i];
                indexMax = i;
            }

        }
        for (int i = 0; i < source.length; i++) {

            if (i == indexMin) {
                dest[i] = max;
            }
            else if (i == indexMax) {
                dest[i] = min;
            }
            else dest[i] = source[i];
        }
        System.out.println(Arrays.toString(dest));
    }
}
