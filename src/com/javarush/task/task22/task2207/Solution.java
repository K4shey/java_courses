package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(filename));
            List<String> textArray = new ArrayList<>();
            while (bufferedReader.ready()) {
                String nextLine = bufferedReader.readLine();
                String[] words = nextLine.split(" ");
                textArray.addAll(Arrays.asList(words));
            }
            boolean needBreak = false;
            for (int i = 0; i < textArray.size(); i++) {
                String wordToCheck = textArray.get(i);
                String reversedWord = new StringBuilder(wordToCheck).reverse().toString();
                for (int j = i+1; j < textArray.size(); j++) {
                    if (textArray.get(j).equals(reversedWord)) {
                        result.add(new Pair(wordToCheck, reversedWord));
                        textArray.remove(wordToCheck);
                        textArray.remove(reversedWord);
                        i--;
                    }
                }
            }
            bufferedReader.close();
            System.out.println(result.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}






























