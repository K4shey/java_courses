package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename1 = args[0];
        String filename2 = args[1];

        Charset charsetWin1251 = Charset.forName("Windows-1251");
        Charset charsetUTF8 = StandardCharsets.UTF_8;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename1), charsetWin1251));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename2), charsetUTF8));

        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            bufferedWriter.write(nextLine + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}






























