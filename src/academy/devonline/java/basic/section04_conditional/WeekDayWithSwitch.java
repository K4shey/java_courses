package academy.devonline.java.basic.section04_conditional;

public class WeekDayWithSwitch {
    public static void main(String[] args) {
        int numberOfDay = 1;
        String result;
        switch (numberOfDay) {

            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
            case 4:
                result = "Thursday";
                break;
            case 5:
                result = "Friday";
                break;
            case 6:
                result = "Saturday";
                break;
            case 7:
                result = "Sunday";
                break;
            default:
                result = "Wrong day number";
        }
        System.out.println(result);
    }
}
