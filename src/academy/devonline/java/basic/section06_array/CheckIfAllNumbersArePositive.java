package academy.devonline.java.basic.section06_array;

public class CheckIfAllNumbersArePositive {
    public static void main(String[] args) {
        boolean allNumbersArePositive = true;
        int [] array = {1, 2, -8, 0, 5};
        for (int element:array
             ) {
            if (element < 0) {
                allNumbersArePositive = false;
                break;
            }
        }
        System.out.println("All numbers" + (allNumbersArePositive ? " are ":" are not ") + "positive");
    }
}
