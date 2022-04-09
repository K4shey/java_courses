package academy.devonline.java.basic.section05_cycles;

public class DisplayNumbersFrom100To1 {
    public static void main(String[] args) {
//        for (var i = 100; i > 1; i--){
//            System.out.print(i + " ");
//        }

        int i = 100;
        while (i > 0) {
            System.out.print(i + " ");
            i--;
        }
    }
}
