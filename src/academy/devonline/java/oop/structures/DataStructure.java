package academy.devonline.java.oop.structures;

public interface DataStructure {

    int size();

    void clear();

    void add(int value);

    void add(int[] array);

    void add(DynaArray dynaArray);

    void add(LinkedList secondList);

    boolean contains(int value);

    boolean remove(int value);

    String asString();

    int[] toArray();

}
