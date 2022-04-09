package academy.devonline.java.basic.section10_practics;

public class BinarySearchRecursive {
    public static void main(String[] args) {

        int[] source = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        int valueToSearch = 16;
        int from = 0;
        int to = source.length - 1;
        System.out.println(FindRecursive(from, to, valueToSearch, source));
    }

    private static int FindRecursive(int from, int to, int valueToSearch, int[] source) {
        int pos = (from + to) / 2;
        if (from > to) {
            return -1;
        }
        if (valueToSearch == source[pos]) {
            return pos;
        } else if (valueToSearch > source[pos]) {
            pos = FindRecursive(pos + 1, to, valueToSearch, source);
            return pos;
        } else if (valueToSearch < source[pos]) {
            pos = FindRecursive(from, pos - 1, valueToSearch, source);
            return pos;
        }
        return -1;
    }
}
