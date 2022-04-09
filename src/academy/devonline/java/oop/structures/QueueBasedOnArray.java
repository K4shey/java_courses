package academy.devonline.java.oop.structures;

import java.util.Arrays;

public final class QueueBasedOnArray extends BasedOnArrayDataStorage {

    public QueueBasedOnArray() {
        this(5);
    }

    public QueueBasedOnArray(int size) {
        result = new int[size];
    }

    @Override
    public int get() {
        if (count == 0) {
            return 0;
        } else {
            int value = result[0];
            int[] newArray = new int[count - 1];
            System.arraycopy(result, 1, newArray, 0, count - 1);
            result = newArray;
            count--;
            return value;
        }
    }

}
