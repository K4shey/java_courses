package academy.devonline.java.basic.section05_cycles;

public class DisplayEvenNumbersFrom0To50_DoWhile {
    public static void main(String[] args) {
        var from = 0;
        var to = 50;
        var step = 2;

        int i = from;
        do {
            System.out.println(i);
            i +=step;
        } while (i <= to);

    }
}
