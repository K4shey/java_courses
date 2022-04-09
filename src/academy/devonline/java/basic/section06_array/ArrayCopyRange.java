package academy.devonline.java.basic.section06_array;

import java.util.Arrays;

public class ArrayCopyRange {
    public static void main(String[] args) {
        int [] source = {1, 2, 3, 4, 5};
        int startIndex = 1;
        int endIndex = 4;
        int newSize = endIndex - startIndex;
        int [] dest = new int[newSize];
        int index = 0;
        for (int i = startIndex ; i < endIndex; i++) {
            dest[index] = source[i];
            index++;
        }
//        for (int element: dest) {
//            System.out.println(element + " ");
//        }
        System.out.println(Arrays.toString(dest));
    }
}
