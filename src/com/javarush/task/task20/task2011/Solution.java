package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File file = File.createTempFile("my_temp_file", null);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        Apartment aptToSerialize = new Apartment("Beverly Hills 90210", 1995);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(aptToSerialize);
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object aptObject  = objectInputStream.readObject();
//        Apartment apt = (Apartment) aptObject;
//        System.out.println(apt.equals(aptToSerialize)); //out false, maybe need to implement eqals method
//        objectOutputStream.close();
//        objectInputStream.close();
    }
}






























