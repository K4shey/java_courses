package academy.devonline.java.basic.section07_String;

public class PrintReverseString {
    public static void main(String[] args) {
        String s = "Hello world!";
        for (int i = s.length(); i > 0 ; i--) {
            System.out.print(s.charAt(i-1));
        }
        System.out.println();
    }
}
