package com.javarush.task.task21.task2109;

/*
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public Object clone() throws CloneNotSupportedException {
            C obj = new C(this.getI(), this.getJ(), this.getName());
            return obj;
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException{

        A a = new A(1,2);
        A cloneA = (A) a.clone();

//        B b = new B(1,2, "hello");
//        B cloneB = (B) b.clone();

        C c = new C(1,2, "hello");
        C cloneC = (C) c.clone();

    }
}






























