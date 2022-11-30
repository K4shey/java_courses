package com.javarush.task.task20.task2028;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    CustomTree.Entry<String> root;

    public CustomTree() {
        this.root = new CustomTree.Entry<String>("Root_Element");
    }

    @Override
    public boolean add(String s) {
        Entry<String> rootElement = root;

        if (rootElement.availableToAddLeftChildren) {
            Entry<String> childElement = new Entry<>("Child_Left_Element");
            childElement.parent = rootElement;
            rootElement.leftChild = childElement;
        } else if (rootElement.availableToAddRightChildren) {
            Entry<String> childElement = new Entry<>("Child_Right_Element");
            childElement.parent = rootElement;
            rootElement.rightChild = childElement;
        }

        return true;
    }

    @Override
    public void add(int index, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

}






























