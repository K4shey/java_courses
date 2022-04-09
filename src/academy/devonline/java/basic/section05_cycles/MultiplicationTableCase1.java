package academy.devonline.java.basic.section05_cycles;

public class MultiplicationTableCase1 {
    public static void main(String[] args) {
        var to = 9;
        for (int i = 1; i <= to; i++) {
            for (int j = 1; j <= to; j++) {
                if (i*j == 1) {
                    System.out.print("\t");
                    continue;
                }
                    System.out.print(i * j + "\t");
            }
            System.out.println("");
        }
    }
}
