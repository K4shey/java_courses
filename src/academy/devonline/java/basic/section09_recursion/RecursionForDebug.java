package academy.devonline.java.basic.section09_recursion;

public class RecursionForDebug {

    public static void main(String[] args) {
//        System.out.println(factorial(5));
        function1(10);
        System.out.println();
        System.out.println(sumOf(100));;
        System.out.println();
        System.out.println(factorial(5));
        System.out.println();
        System.out.println(sumTo10(10));
    }

/*
    private static int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * factorial(n-1);
        return result;
    }
*/
    private static int sumTo10(int value){
        if (value == 0) {
            return 0;
        } else {
            int valuep = sumTo10(value - 1);
            value += valuep;
            return value;
        }

    }

    private static int sumOf(int value){
        if (value == 0){
            return 0;
        }  else {
            int prevSum = sumOf( value - 1);
            return value  + prevSum;
        }
    }

    private static void function1 (int value){
        if (value > 0) {
            function1(value - 1);
            System.out.print(value + "\t");
        }
    }

    private static int factorial(int value){
        if (value == 0 || value ==1) {
            return 1;
        } else{
            return value * factorial(value - 1);
        }
    }

}
