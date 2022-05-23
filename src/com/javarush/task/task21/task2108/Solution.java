package com.javarush.task.task21.task2108;

/*
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
//        try {
        clone = (Tree) tree.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(Arrays.toString(tree.branches));
        System.out.println(Arrays.toString(clone.branches));
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Tree newtree = new Tree(this.getName(), null);
            String[] sourceBranches = this.getBranches();
            String[] newBranches = new String[sourceBranches.length];
            for (int i = 0; i < sourceBranches.length; i++) {
                newBranches[i] = sourceBranches[i];
            }
            newtree.branches = newBranches;
            return newtree;
        }
    }
}






























