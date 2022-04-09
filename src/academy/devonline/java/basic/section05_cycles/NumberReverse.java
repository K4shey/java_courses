package academy.devonline.java.basic.section05_cycles;

import java.util.Scanner;

public class NumberReverse {
    public static void main(String[] args) {
//        String numberToReverse = "21653984923";
//        int index = numberToReverse.length() - 1;
//        while (index >= 0){
//            System.out.print(numberToReverse.charAt(index));
//            index--;
//        }
        int numberToReverse = 392179;
        var result = 0;
        while (numberToReverse > 0) {
            result = result * 10 + (numberToReverse % 10);
            numberToReverse = numberToReverse / 10;
        }
        System.out.print(result);
    }
}
