package academy.devonline.java.oop.structures;

public abstract class BaseDataStructure implements DataStructure {

    protected int count;

    public final int size(){
        return count;
    }

    public void clear() {
        count = 0;
    }

    public abstract void add(int value);

    public void add(int[] array) {
        for (int element : array) add(element);
    }

    public void add(DynaArray dynaArray) {
        add(dynaArray.toArray());
    }

    public void add(LinkedList secondList) {
        add(secondList.toArray());
    }

}
