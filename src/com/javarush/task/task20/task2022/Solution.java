package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public Solution() {

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.writeObject(stream);
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.filename, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("d:\\downloads\\solution.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream("d:\\downloads\\solution.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Solution solution = new Solution("d:\\downloads\\test7.txt");
            solution.writeObject("test test bla bla lba");
            objectOutputStream.writeObject(solution);
            objectOutputStream.flush();
            Solution newSolution = new Solution();
            newSolution = (Solution) objectInputStream.readObject();
            newSolution.writeObject("next new line");

        } catch (Exception e) {

        }
    }
}






























