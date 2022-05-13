package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/*
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
//        super(file);
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
//        super(fileName, append);
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
//        super(fd);
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
//        super(fileName);
        this.fileWriter = new FileWriter(fileName);
    }


    public FileConsoleWriter(File file, boolean append) throws IOException {
//        super(file, append);
        this.fileWriter = new FileWriter(file, append);
    }


    public static void main(String[] args) throws IOException {
//        FileConsoleWriter fcw = new FileConsoleWriter("d:\\Downloads\\test4.txt");
//        char[] cbuf = new char[]{'1', '2', '3', '4', '5', '6'};
//        fcw.write(cbuf, 2,3);
    }

    public void write(int c) throws IOException {
//        super.write(c);
        fileWriter.write(c);
        System.out.println(c);
    }


    public void write(char[] cbuf) throws IOException {
//        super.write(cbuf);
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
//        super.write(cbuf, off, len);
        fileWriter.write(cbuf, off, len);
        char[] subArray = new char[len];
        System.arraycopy(cbuf, off, subArray, 0, len);
        System.out.println(subArray);
    }

    public void write(String str) throws IOException {
//        super.write(str);
        fileWriter.write(str);
        System.out.println(str);
    }


    public void write(String str, int off, int len) throws IOException {
//        super.write(str, off, len);
        fileWriter.write(str, off, len);
        System.out.println(str.toString().substring(off, off + len));
    }


    public void close() throws IOException {
//        super.close();
        fileWriter.close();
    }
}






























