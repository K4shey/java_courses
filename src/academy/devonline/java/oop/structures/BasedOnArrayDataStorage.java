package academy.devonline.java.oop.structures;

import java.util.Arrays;

public abstract class BasedOnArrayDataStorage implements DataStorage {

   protected int[] result;
   protected int count;

    public BasedOnArrayDataStorage() {
        this(5);
    }

    public BasedOnArrayDataStorage(int size) {
        result = new int[size];
    }

    @Override
    public  final void add(int value) {
        if (count == result.length){
            grow();
        }
        result[count] = value;
        count++;
    }

    private void grow(){
        int[] newArray = new int[count * 2];
        System.arraycopy(result, 0, newArray, 0, count );
        result = newArray;
    }

    @Override
    public final int size()
    {
        return count;
    }

    @Override
    public final String asString()
    {
        return Arrays.toString(Arrays.copyOf(result, count));
    }

}
