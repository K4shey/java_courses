package academy.devonline.java.basic.section03_expression;

public class SwapVariables {
    public static void main (String[] args){

        int a = 5;
        int b = 3;
        Math.random();
        System.out.println("Start values:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int c = a;
        a = b;
        b = c;

        System.out.println("Values after exchange:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);



    }

}
