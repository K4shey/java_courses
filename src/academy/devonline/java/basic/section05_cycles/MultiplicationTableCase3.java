package academy.devonline.java.basic.section05_cycles;

public class MultiplicationTableCase3 {
    public static void main(String[] args) {
        var to = 9;
//        var firstTo = (to/2) + 1;
//        for (int i = 2; i <= to ; i++) {
//            for (int j = 2; j <= firstTo ; j++) {
//                System.out.print("" + j + " * " + i + " = " + i*j + "\t");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//        for (int i = 2; i <= to ; i++) {
//            for (int j = firstTo + 1; j <= to  ; j++) {
//                System.out.print("" + j + " * " + i + " = " + i*j + "\t");
//            }
//            System.out.println("");
//
//        }

        for (int k = 2; k <= to; k += 4) {
            for (int i = 2; i <= to ; i++) {
                for (int j = k ; j < k + 4  ; j++) {
                    System.out.print("" + j + " * " + i + " = " + i*j + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
