package academy.devonline.java.basic.section03_expression;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("Enter 'a':");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Enter 'b':");
        int b = new Scanner(System.in).nextInt();

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

    }
}
