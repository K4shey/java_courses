package academy.devonline.java.basic.section04_conditional;

import java.util.Scanner;

public class WeekDay {
    public static void main(String[] args) {
        System.out.println("Enter number of day:");
        int numOfDay = new Scanner(System.in).nextInt();
        if (numOfDay == 1){
            System.out.println("Monday");
        } else if (numOfDay == 2){
            System.out.println("Tuesday");
        } else if (numOfDay == 3) {
            System.out.println("Wednesday");
        } else if (numOfDay == 4) {
            System.out.println("Thursday");
        } else if (numOfDay == 5) {
            System.out.println("Friday");
        } else if (numOfDay == 6) {
            System.out.println("Saturday");
        } else if (numOfDay == 7) {
            System.out.println("Sunday");
        }
          else {
              System.out.println("Wrong number entered");
            }
        }
    }
