package academy.devonline.java.basic.section04_conditional;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        boolean yearIsLeap = false;
        System.out.println("Enter a year:");
        int year = new Scanner(System.in).nextInt();
//        if (year % 400 == 0) {
//            yearIsLeap = true;
//        }
//        else if (year % 100 == 0) {
//            yearIsLeap = false;
//        }
//        else if (year % 4 == 0) {
//            yearIsLeap = true;
//        }

        if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0) ) ) {
            yearIsLeap = true;
        }



        System.out.println("Year " + year + " is " +  (yearIsLeap  ? "leap" : "not leap"));
    }
}
