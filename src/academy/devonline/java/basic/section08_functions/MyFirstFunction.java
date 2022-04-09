package academy.devonline.java.basic.section08_functions;

public class MyFirstFunction {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int res = multiply(a, b);
        System.out.println(res);

    }

    public static int multiply(int a, int b) {
        return a * b;
    }

}
