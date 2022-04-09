package academy.devonline.java.basic.section06_array;

public class ArrayElementCount {
    public static void main(String[] args) {
        int numberToFind = 2;
        int [] array = {5, 2, 3, 4, 4, 3, 3, 2, 2, 2, 2, 2};
        int total = 0;
        for (int element: array
             ) {
            if (element == numberToFind) {
                total++;
            }

        }
        System.out.println(total);
    }
}
