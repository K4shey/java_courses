package academy.devonline.java.basic.section09_recursion;

public class LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] array = {6, 1, 2, 9, 4, 8, 0, 7, 2, 3};
        var query = 11;
        var index = 0;
        System.out.println(findIndex(array, query));
        System.out.println(findIndexRecursive(array, index, query));

    }

    private static int findIndexRecursive(int[] array, int index, int query) {
        if (index == array.length ){
            return -1;
        }
        if (array[index] !=query) {
            return findIndexRecursive(array, index+1, query);
        } else {
            return index;
        }

    }

    // Iterative
    private static int findIndex(int[] array, int query) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == query) {
                return i;
            }
        }
        return -1;
    }

}
