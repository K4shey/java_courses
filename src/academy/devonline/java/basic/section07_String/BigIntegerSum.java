package academy.devonline.java.basic.section07_String;

import java.math.BigInteger;

public class BigIntegerSum {
    public static void main(String[] args) {
        String a = "123456789012345678901234567890123456789012345678901234567890";
        String b =           "12345678901234567890123456789012345678901234567890";
        String maxS = "";
        String minS = "";
        StringBuilder res = new StringBuilder();

        if (a.length() <= b.length()) {
            maxS = b;
            minS = a;
        } else {
            maxS = a;
            minS = b;
        }
        int countMin = minS.length() - 1;
        int countMax = maxS.length() - 1;
        int prev = 0;
        int a1 = 0;
        int b1 = 0;

         for (int i = countMax; i >= 0; i--) {
//                int a1 = Character.getNumericValue(maxS.charAt(i));
             a1 = Integer.parseInt(String.valueOf(maxS.charAt(i)));
//              if (i > countMax-countMin) {
             if (i > countMax - minS.length()) {
//                int b1 = Character.getNumericValue(minS.charAt(countMin));
                b1 = Integer.parseInt(String.valueOf(minS.charAt(countMin)));
                int sum = a1 + b1 + prev;
                System.out.println("a1 = " + a1 + " b1 = " + b1 + " prev=" + prev);
                if (sum > 9) {
                    sum = sum - 10;
                    prev = 1;
                } else {
                    prev = 0;
                }
                res.insert(0, sum);
                countMin--;
            } else {
//                res.insert(0, Character.getNumericValue(maxS.charAt(i)));
                res.insert(0, a1+prev);
                System.out.println("a1 = " + a1 + " prev=" + prev);
                prev = 0;
            }
        }
        System.out.println(res.toString());
        System.out.println(new BigInteger(a).add(new BigInteger(b))) ;
    }
}
