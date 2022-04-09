package academy.devonline.java.basic.section04_conditional;

import java.util.Scanner;

public class UniversalWeekDay {
    public static void main(String[] args) {
        // Input data
        System.out.println("Enter number of day");
        int numberOfDay = new Scanner(System.in).nextInt();
        System.out.println("Is Monday first day of week? (true/false)");
        boolean isMondayFirst = new Scanner(System.in).nextBoolean();
        String result = "";
        // Processing
        if (numberOfDay == 1) {
            if (isMondayFirst) {
                result = "Monday";
            } else {
                result = "Sunday";
            }
        } else if (numberOfDay == 2) {
            if (isMondayFirst) {
                result = "Tuesday";
            } else {
                result = "Monday";
            }
        } else if (numberOfDay == 3) {
            if (isMondayFirst) {
                result = "Wednesday";
            } else {
                result = "Tuesday";
            }
        } else if (numberOfDay == 4) {
            if (isMondayFirst) {
                result = "Thursday";
            } else {
                result = "Wednesday";
            }
        } else if (numberOfDay == 5) {
            if (isMondayFirst) {
                result = "Friday";
            } else {
                result = "Thursday";
            }
        } else if (numberOfDay == 6) {
            if (isMondayFirst) {
                result = "Saturday";
            } else {
                result = "Friday";
            }
        } else if (numberOfDay == 7) {
            if (isMondayFirst) {
                result = "Sunday";
            } else {
                result = "Saturday";
            }
        } else {
            System.out.println("Wrong day's number entered");
        }




        //Output result
        System.out.println(result);
    }
}
