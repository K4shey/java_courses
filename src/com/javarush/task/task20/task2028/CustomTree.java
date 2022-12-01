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
        this.root = new CustomTree.Entry<String>("0");
    }

    @Override
    public boolean add(String s) {
//        Entry<String> currentElement = root;
        Entry<String> childElement = new Entry<>(s);
//
//        Entry<String> childElement = new Entry<>("1");
//        currentElement.leftChild = childElement;
//        childElement.parent = currentElement.leftChild;
//        currentElement.availableToAddLeftChildren = false;
//
//        childElement = new Entry<>("2");
//        currentElement.rightChild = childElement;
//        childElement.parent = currentElement.rightChild;
//        currentElement.availableToAddRightChildren = false;
//
//        currentElement = root.leftChild;
//
//
//        childElement = new Entry<>("3");
//        currentElement.leftChild = childElement;
//        childElement.parent = currentElement.leftChild;
//        currentElement.availableToAddLeftChildren = false;
//
//        childElement = new Entry<>("4");
//        currentElement.rightChild = childElement;
//        childElement.parent = currentElement.rightChild;
//        currentElement.availableToAddRightChildren = false;
//
//        currentElement = root.rightChild;
//
//
//        childElement = new Entry<>("5");
//        currentElement.leftChild = childElement;
//        childElement.parent = currentElement.leftChild;
//        currentElement.availableToAddLeftChildren = false;

//        Queue<Entry<String>> queue = new PriorityQueue<>();
        Entry<String> nextEntry = null;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            nextEntry = queue.poll();
            if (nextEntry != null) {
                System.out.print(nextEntry.elementName + " ");
                if (nextEntry.leftChild != null) {
                    queue.add(nextEntry.leftChild);
                }
                if (nextEntry.rightChild != null) {
                    queue.add(nextEntry.rightChild);
                }
            }
        }
        if (nextEntry.availableToAddLeftChildren) {
            childElement.parent = nextEntry;
            nextEntry.leftChild = childElement;
            nextEntry.availableToAddLeftChildren = false;
        } else if (nextEntry.availableToAddRightChildren) {
            childElement.parent = nextEntry;
            nextEntry.rightChild = childElement;
            nextEntry.availableToAddRightChildren = false;
        }
        System.out.print(childElement.elementName);
        System.out.println();
        return true;
    }


    public void traversal(Entry<String> entry) {
        Entry<String> currentElement = entry;
        while (!currentElement.isAvailableToAddChildren()) {
            currentElement = currentElement.leftChild;
        }

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
     int size = -1;
        Entry<String> nextEntry = null;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            nextEntry = queue.poll();
            if (nextEntry != null) {
                size++;
                if (nextEntry.leftChild != null) {
                    queue.add(nextEntry.leftChild);
                }
                if (nextEntry.rightChild != null) {
                    queue.add(nextEntry.rightChild);
                }
            }
        }
        return size;
    }

    public String getParent(String s) {
        String parent = "";
        Entry<String> nextEntry = null;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            nextEntry = queue.poll();
            if (nextEntry != null) {
                if (nextEntry.elementName.equals(s)) {
                    parent = nextEntry.parent.elementName;
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






























