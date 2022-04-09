package academy.devonline.java.basic.section10_practics;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] source = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        int valueToSearch = 1;
        int result = -1;
        boolean stop = false;
        int from = 0;
        int to = source.length - 1;
        while (from <= to) {
            int pos = (from + to) / 2;
            if (valueToSearch == source[pos]) {
                result = pos;
                break;
            } else if (valueToSearch > source[pos]) {
                from = pos + 1;
            } else if (valueToSearch < source[pos]) {
                to = pos - 1;
     //       } else {
     //           result = pos;
            }
        }
        System.out.println(result);
    }

}
