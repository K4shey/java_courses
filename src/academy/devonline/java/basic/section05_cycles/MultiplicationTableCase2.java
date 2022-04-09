package academy.devonline.java.basic.section05_cycles;

public class MultiplicationTableCase2 {
    public static void main(String[] args) {
        var to = 9;
        for (int i = 2; i <= to; i++) {
            for (int j = 2; j <= to; j++) {
                System.out.println("" + i + " * " + j + " = " + i*j);
            }
            System.out.println();
        }
    }
}
