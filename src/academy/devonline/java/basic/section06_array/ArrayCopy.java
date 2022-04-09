package academy.devonline.java.basic.section06_array;

public class ArrayCopy {
    public static void main(String[] args) {
        int [] source = {1, 2, 3, 4, 5};
        int [] dest = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
        for (int element: dest) {
            System.out.print(element + " ");
        }
    }
}
