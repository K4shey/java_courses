package academy.devonline.java.basic.section04_conditional;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Integer number = new Random().nextInt(10);
        System.out.println(number);
        System.out.println("Enter the secret number (0..9)");
        Integer guess = new Scanner(System.in).nextInt();
//        if (number == guess) {
//            System.out.println("Congratulations, you guessed the number!");
//        } else {
//            System.out.println("Sorry, but your number is invalid! Try again later...");
//        }
        System.out.println( number == guess ? "Congratulations, you guessed the number!" : "Sorry, but your number is invalid! Try again later...");


    }
}
