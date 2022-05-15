package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/*
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;
//        private boolean hasChildren;
//        private boolean hasMother;
//        private boolean hasFather;


        public Person() {

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
//            this.hasMother = true;
        }

        public void setFather(Person father) {
            this.father = father;
//            this.hasFather = true;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
//            this.hasChildren = true;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
//            out.writeBoolean(hasMother);
//            out.writeBoolean(hasFather);
//            out.writeBoolean(hasChildren);
//            if (hasMother) {
                out.writeObject(mother);
//            }
//            if (hasFather) {
                out.writeObject(father);
//            }
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(age);
//            if (hasChildren) {
                out.writeObject(children);
//            }
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//            hasMother = in.readBoolean();
//            hasFather = in.readBoolean();
//            hasChildren = in.readBoolean();
//            if (hasMother) {
                mother = (Person) in.readObject();
//            }
//            if (hasFather) {
                father = (Person) in.readObject();
//            }
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = (Integer) in.readObject();
//            if (hasChildren) {
                children = (List) in.readObject();
//            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File file = File.createTempFile("my_temp_file", null);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        Person personToSerialize = new Person("Benny", "Hill", 88);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(personToSerialize);
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object personObject = objectInputStream.readObject();
//        Person person = (Person) personObject;
//        System.out.println(person.equals(personToSerialize)); //out false, maybe need to implement eqals method
//        objectOutputStream.close();
//        objectInputStream.close();
    }
}






























