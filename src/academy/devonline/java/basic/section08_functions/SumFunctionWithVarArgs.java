package academy.devonline.java.basic.section08_functions;

public class SumFunctionWithVarArgs {
    public static void main(String[] args) {
        System.out.println(sumOf(2, 5, 7, 4, 2, 8));
        System.out.println(sumOf());
        System.out.println(sumOf(2, 5, 1));
    }

    private static int sumOf(int... args) {
        int sum = 0;
        for (int nextNumber : args
        ) {
            sum += nextNumber;
        }
        return sum;
    }

}
