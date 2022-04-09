package academy.devonline.java.basic.section07_String;

public class FindMinString {
    public static void main(String[] args) {
        String [] array = {"one", "two", "three", "four", "five"};
        String minString = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(minString) < 0 ) {
                minString = array[i];
            }
        }
        System.out.println("Min string = " + minString);
    }
}
