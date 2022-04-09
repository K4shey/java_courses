package academy.devonline.java.oop.structures;

public class LinkedList extends BaseDataStructure {

    private Item first;
    private Item last;

    @Override
    public void add(int value) {

        Item newItem = new Item(value);

        if (first == null) {
            first = last = newItem;
        } else {
            last.next = newItem;
            last = newItem;
        }
        count++;

    }

    @Override
    public void add(LinkedList secondList) {
//          my solution
//        add(secondList.toArray());

//         tutor's solution
//        if (secondList.size() > 0) {
        if (secondList.count > 0) {
            if (first == null && last == null) {
                first = secondList.first;
                last = secondList.last;
            }
            else {
                last.next = secondList.first;
                last = secondList.last;
            }
            count +=secondList.count;
        }

    }

    public int[] toArray() {

//        DynaArray dynaArray = new DynaArray();
//        Item currentItem = first;
//
//        while (currentItem != null) {
//            dynaArray.add(currentItem.value);
//            currentItem = currentItem.next;
//        }
//        return dynaArray.toArray();

        int[] array = new int[count];
        Item currentItem = first;
        int index = 0;
        while (currentItem != null) {
            array[index++] = currentItem.value;
            currentItem = currentItem.next;
        }
       return array;
    }

    @Override
    public void clear() {
        first = last = null;
        super.clear();
    }

//    public int size() {
//        int size = 0;
//        Item currentItem = first;
//        while (currentItem != null) {
//            size++;
//            currentItem = currentItem.next;
//        }
//        return size;
//    }


    public String asString() {
        StringBuilder sb = new StringBuilder();
        Item currentItem = first;
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

    public boolean remove(int value) {

        // mine solution
//        boolean result = false;
//        int[] array =  this.toArray();
//        DynaArray dynaArray = new DynaArray();
//        dynaArray.add(array);
//        result = dynaArray.remove(value);
//        array = dynaArray.toArray();
//        this.clear();
//        for (int element: array) {
//           this.add(element);
//        }
//        return result;

        //tutor's solution
        Pair pair = findPair(value);
        if (pair == null) {
            return false;
        } else {
            if (pair.current == last && pair.current == first) {
                first = null;
                last = null;
            } else if (pair.current == first) {
                first = first.next;
            } else {
                pair.previous.next = pair.current.next;
                if (pair.current == last) {
                    last = pair.previous;
                }
            }
            count--;
            return true;
        }
    }

    public boolean contains(int value) {
        // my solution
//       Item currentItem = first;
//       while (currentItem != null) {
//           if (currentItem.value == value){
//               return true;
//           }
//           currentItem = currentItem.next;
//       }
//       return false;

        // tutor's solution
        return findPair(value) != null;
    }


    private Pair findPair(int value) {

        Item previousItem = first;
        Item currentItem = first;

        while (currentItem != null) {
            if (currentItem.value == value) {
                Pair pair = new Pair(previousItem, currentItem);
                return pair;
            }
            previousItem = currentItem;
            currentItem = currentItem.next;
        }
        return null;
    }

    private static class Pair {

        Item previous;
        Item current;

        private Pair(Item previous, Item current) {
            this.previous = previous;
            this.current = current;
        }
    }

    private static class Item {
        int value;
        Item next;

        public Item(int value) {
            this.value = value;
        }
    }
}
