package academy.devonline.java.basic.section06_array;

public class ArrayElementSum {
    public static void main(String[] args) {
        int sum = 0;
        int [] array = {1, 2, 3, 4, 5};
        for (int element:array
             ) {
            sum += element;
        }
        System.out.println(sum);
    }
}
