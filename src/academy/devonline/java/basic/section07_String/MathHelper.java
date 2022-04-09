package academy.devonline.java.basic.section07_String;
import java.util.Scanner;

public class MathHelper {
    public static void main(String[] args) {
        System.out.println("Enter cmd: {pi, e, exit or quit}");
        while (true) {
            String cmd = new Scanner(System.in).nextLine();
            cmd = cmd.toLowerCase();
            if (cmd.equals("quit") || cmd.equals("exit")) {
                break;
            } else if (cmd.equals("pi")) {
                System.out.println(Math.PI);
            } else if (cmd.equals("e")) {
                System.out.println(Math.E);
            } else {
                System.out.println("Invalid cmd. Try again!");
            }
        }
        System.out.println("Quited");
    }
}
