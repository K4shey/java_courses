package academy.devonline.java.basic.section08_functions;

public class SumLibrary {
    public static void main(String[] args) {

        System.out.println("int = " + sumOf( 1, 2));
        System.out.println("short = " + sumOf((short) 1,(short) 2));
        System.out.println("long = " + sumOf((long) 1,(long) 2));
        System.out.println("double = " + sumOf((double) 1.,(double) 2.));
        System.out.println("float = " + sumOf((float) 1.,(float) 2.));

    }

    private static int sumOf(int a, int b) {
         return a + b;
    }

    private static short sumOf(short a, short b) {
        return (short) (a + b);
    }

    private static long sumOf(long a, long b) {
        return a + b;
    }

    private static double sumOf(double a, double b) {
        return a + b;
    }

    private static float sumOf(float a, float b) {
        return a + b;
    }

}
