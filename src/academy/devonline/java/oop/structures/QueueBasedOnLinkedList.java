package academy.devonline.java.oop.structures;

public class QueueBasedOnLinkedList implements DataStorage{

    ListItem tail;
    ListItem head;
    int size;

    @Override
    public void add(int value) {
        ListItem newItem = new ListItem(value);
        ListItem tmp = tail;
        tail = newItem;

        if (size == 0) {
            head = tail;
        } else {
            tmp.next = tail;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get() {
        ListItem tmp = head;
        head = head.next;
        size--;
        return tmp.value;
    }

    @Override
    public String asString() {
        StringBuilder sb = new StringBuilder();
        ListItem currentItem = head;
        sb.append('[');
        while (currentItem != null) {
            sb.append(currentItem.value);
            currentItem = currentItem.next;
            if (currentItem != null) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private class ListItem{

        int value;
        ListItem next;

        ListItem(int value){
            this.value = value;
        }

    }
}
