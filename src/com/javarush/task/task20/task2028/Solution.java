package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.size());
        CustomTree tree = (CustomTree) list;
        System.out.println(tree.getParent("3"));
        System.out.println(tree.getParent("5"));
    }
}






























