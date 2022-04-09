package academy.devonline.java.basic.section09_recursion;

public class FindMinElementUsingRecursion {

    public static void main(String[] args) {
        int[] array = {1, -2, 8, 0, 5, 6, 6, -8, 9, -22, 1};
//        System.out.println(findMin(array));
        System.out.println(findMinRecursive(array, 0, array[0]));
    }

    // Iterative
//    private static int findMin(int[] array) {
//        var min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < min) {
//                min = array[i];
//            }
//        }
//        return min;
//    }
    // Recursive
    private static int findMinRecursive(int [] array, int index, int min) {
        if (index > array.length-1) {
            return min;
        }
        if (array[index] < min) {
            min = array[index];
        }
        return findMinRecursive(array, index + 1, min);
    }
}
