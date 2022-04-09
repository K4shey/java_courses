package academy.devonline.java.basic.section06_array;

public class FindMinElement {
    public static void main(String[] args) {
        int [] array = {1, -2, 8, 0, -5};
        int minElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        System.out.println("Minimum element of array is " + minElement);
    }
}
