package com.javarush.task.task20.task2028;

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

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        ArrayList<Entry> toRemove = new ArrayList<>();
        Entry startElement = null;

        for (Entry nextEntry : allElements) {
            if (nextEntry.elementName.equals(o)) {
                if (nextEntry.parent.leftChild != null && nextEntry.parent.leftChild.elementName.equals(nextEntry.elementName)) {
                    nextEntry.parent.leftChild = null;
                    startElement = nextEntry;
                    break;
                } else if (nextEntry.parent.rightChild != null && nextEntry.parent.rightChild.elementName.equals(nextEntry.elementName)) {
                    nextEntry.parent.rightChild = null;
                    startElement = nextEntry;
                    break;
                }
            }
        }



        Stack<CustomTree.Entry> stack = new Stack<>();
        stack.push(startElement);
        while (!stack.empty()) {
            Entry nextEntry = stack.pop();
            if (nextEntry.parent.rightChild == null && nextEntry.parent.leftChild == null) {
                nextEntry.parent.availableToAddLeftChildren = true;
                nextEntry.parent.availableToAddRightChildren = true;
            }
            toRemove.add(nextEntry);
            if (nextEntry != null) {
                if (nextEntry.leftChild != null) {
                    stack.push(nextEntry.leftChild);
                }
                if (nextEntry.rightChild != null) {
                    stack.push(nextEntry.rightChild);
                }
            }
        }
        for (int i = 0; i < toRemove.size(); i++) {
            Entry nextToRemove = toRemove.get(i);
            if (allElements.contains(nextToRemove)) {
                allElements.remove(nextToRemove);
            }
        }
        return true;
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
