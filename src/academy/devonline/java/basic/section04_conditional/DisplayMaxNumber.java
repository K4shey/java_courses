package academy.devonline.java.basic.section04_conditional;

public class DisplayMaxNumber {
    public static void main(String[] args) {
        int a = 5;
        int b = 1;
        System.out.println(max(a,b));
    }

    public static int max (int a, int b){
       return a - b < 0 ? b:a;
    }
}
