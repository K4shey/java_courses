package academy.devonline.java.basic.section05_cycles;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        boolean overflow = false;
        System.out.println("Enter the number fo factorial calculation");
        int i = new Scanner(System.in).nextInt();
        if (i < 0) {
            System.out.println("Value should be >=0");
        } else {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                var prevValue = factorial;
                factorial *= j;
                if (factorial != prevValue/ j) {
                    overflow = true;
                    break;
                }

            }
            if (overflow == true) {
                System.out.println("Int overflow");
            } else {
                System.out.println("Factorial = " + factorial);
            }

        }
    }
}
