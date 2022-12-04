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
    ArrayList<Entry> allElements = new ArrayList<>();

    public CustomTree() {
        this.root = new CustomTree.Entry<String>("0");
    }

    @Override
    public boolean add(String s) {

        Entry<String> childElement = new Entry<>(s);
        Entry<String> nextEntry = null;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            nextEntry = queue.poll();
            if (nextEntry != null) {
                if (nextEntry.availableToAddLeftChildren) {
                    childElement.parent = nextEntry;
                    nextEntry.leftChild = childElement;
                    nextEntry.availableToAddLeftChildren = false;
                    allElements.add(childElement);
                    break;
                } else if (nextEntry.availableToAddRightChildren) {
                    childElement.parent = nextEntry;
                    nextEntry.rightChild = childElement;
                    nextEntry.availableToAddRightChildren = false;
                    allElements.add(childElement);
                    break;
                }
                if (nextEntry.leftChild != null) {
                    queue.add(nextEntry.leftChild);
                }
                if (nextEntry.rightChild != null) {
                    queue.add(nextEntry.rightChild);
                }
            }
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
        return allElements.size();
    }

    public String getParent(String s) {
        String parent = null;
        for (Entry nextEntry : allElements) {
            if (nextEntry.elementName.equals(s)) {
                parent = nextEntry.parent.elementName;
                break;
            }
        }
        return parent;
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
