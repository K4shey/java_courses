package academy.devonline.java.basic.section05_cycles;

public class DisplayNumbersFrom100To1_DoWhile {
    public static void main(String[] args) {
//        for (var i = 100; i > 1; i--){
//            System.out.print(i + " ");
//        }
        var from = 100;
        var to = 1;
        int i = from;
        do  {
            System.out.print(i + " ");
            i--;
        } while (i > 0);
    }
}
