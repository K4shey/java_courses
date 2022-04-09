package academy.devonline.java.basic.section07_String;

public class ReverseStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello world!");
        StringBuilder res = sb.reverse();
        System.out.println(res);
    }
}
