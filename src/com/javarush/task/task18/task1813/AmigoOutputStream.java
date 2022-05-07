package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream stream;

    public AmigoOutputStream(FileOutputStream stream) throws FileNotFoundException {
        super(fileName);
        this.stream = stream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public void flush() throws IOException {
        stream.flush();
    }

    public void write(int b) throws IOException {
        stream.write(b);
    }

    public void write(byte[] buffer) throws IOException {
        stream.write(buffer);
    }

    public void write(byte b[], int off, int len) throws IOException {
        stream.write(b, off, len);
    }



    @Override
    public void close() throws IOException {
        flush();
        String copyright = "JavaRush © All rights reserved.";
        write(copyright.getBytes());
        stream.close();
    }

}






























