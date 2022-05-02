package com.javarush.task.task16.task1630;

import java.io.*;

/*
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong " + e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread  extends Thread implements ReadFileInterface {

        private String filename = "";
        public String content = "";

        public void setFileName(String fullFileName) {

            filename = fullFileName;
        }

        public String getFileContent() {
            return  content;
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
                while (bufferedReader.ready()) {
                    String nextLine = bufferedReader.readLine();
                    content += nextLine + " ";
                }
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Something went wrong " + e);
            }
        }

    }
}






























