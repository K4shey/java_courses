package academy.devonline.java.basic.section10_practics;

import java.awt.desktop.AppReopenedEvent;

public class SimplestTextArchiver {
    public static void main(String[] args) {
        // read source data
       String source = "A".repeat(8) + "B".repeat(3) + "C".repeat(5);
//        String source = "A".repeat(1) + "B".repeat(1) + "C".repeat(6) +"D".repeat(1);
        System.out.println("Source text:   " + source);

        // processing
        String zipped = zip(source);
        // display results
        System.out.println("Zipped text:   " + zipped);

        // processing
        String unzipped = unzip(zipped);
        // display results
        System.out.println("Unzipped text: " + unzipped);
    }

    private static String zip(String source) {
        // Your implementation must be here
        int i = 0;
        int count = 1;
        StringBuilder result = new StringBuilder();
        while (true) {
            char prevChar = source.charAt(i);
            i++;
            if (i >= source.length()) {
                result.append(prevChar);
                result.append(count);
                break;
            }
            if (prevChar == source.charAt(i)) {
                count++;
            } else {
                result.append(prevChar);
                result.append(count);
                count = 1;
            }
       }
        return result.toString();
    }

    private static String unzip(String zipped) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < zipped.length(); i += 2) {
            char currentChar = zipped.charAt(i);
            int count = Integer.parseInt(String.valueOf(zipped.charAt(i+1)));
            for (int j = 0; j < count; j++) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
