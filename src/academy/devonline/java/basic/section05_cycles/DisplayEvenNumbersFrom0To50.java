package academy.devonline.java.basic.section05_cycles;

public class DisplayEvenNumbersFrom0To50 {
    public static void main(String[] args) {
        var from = 0;
        var to = 50;
        var step = 1;

//        for (int i = from; i <=to ; i += step) {
//
//            if (i % 2 == 0) {
//                System.out.println(i + " ");
//            }
//        }
        int i = from;
        while (i <= to) {
            System.out.println(i);
            i +=2;
        }

    }
}
