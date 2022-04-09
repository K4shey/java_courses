package academy.devonline.java.oop.structures;

public class StackBasedOnLinkedList implements DataStorage{

    ListItem head;
    int size;


    @Override
    public void add(int value) {
        ListItem newItem = new ListItem(value);
        ListItem tmp = head;
        head = newItem;
        if (tmp != null) {
            head.next = tmp;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get() {
        if (head != null) {
//            ListItem tmp = head;
            int result = head.value;
            head = head.next;
//            tmp.next = null;
            size--;
            return result;
        } else {
            return 0;
        }
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
