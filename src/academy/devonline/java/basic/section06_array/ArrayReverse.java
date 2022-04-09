package academy.devonline.java.basic.section06_array;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int [] array = {7, 2, 3, 4, 5, 6, 8, 9};
//        int [] tempArray = new int[array.length];
//        int index = array.length-1;
//        for (int element:array
//             ) {
//            tempArray[index] = element;
//            index--;
//        }
////        System.out.println(Arrays.toString(tempArray));
//        index = 0;
//        for (int element:tempArray
//             ) {
//            array[index] = element;
//            index++;
//        }
//        System.out.println(Arrays.toString(array));
//    }
        for (int i = 0; i < array.length/2 ; i++) {
            int temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
        }
}
