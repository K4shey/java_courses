package academy.devonline.java.oop.structures;

import java.util.Arrays;

public final class StackBasedOnArray extends BasedOnArrayDataStorage {

    public StackBasedOnArray() {
        this(5);
    }

    public StackBasedOnArray(int size) {
        result = new int[size];
    }

    @Override
    public int get() {
        if (count == 0 ){
            return 0;
        } else {
            int value = result[count-1];
            int[] newArray = new int[count - 1];
            System.arraycopy(result, 0, newArray, 0, count - 1);
            result = newArray;
            count--;
            return value;
        }
    }

}
