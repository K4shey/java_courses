package academy.devonline.java.basic.section05_cycles;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberInfinite {
    public static void main(String[] args) {
        Integer number = new Random().nextInt(10);
        System.out.println(number);
        while (true) {
            System.out.println("Enter the secret number (0..9)");
            Integer guess = new Scanner(System.in).nextInt();
            if (number == guess) {
                System.out.println("Congratulations, you guessed the number!");
                break;
            } else if (number > guess) {
                    System.out.println("number > " + guess + ". Try again");
                } else {
                System.out.println("number < " + guess + ". Try again");
            }
        }
    }
}
