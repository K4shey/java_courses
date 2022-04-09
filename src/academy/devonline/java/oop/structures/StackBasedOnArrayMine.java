package academy.devonline.java.oop.structures;

import java.util.Arrays;

public class StackBasedOnArrayMine implements DataStorage {

   private int[] array = new int[5];
//    int count;
    private int top;

    @Override
    public void add(int value) {
        if (size()!=0 && top == size()){
            increase();
        }
        array[top++] = value;
//  my solution #1
//        int[] newArray  = new int[++count];
//        newArray = Arrays.copyOf(array, count);
//        newArray[count - 1] = value;
//        array = newArray;
    }

    private void increase(){
        int[] newArray = new int[size() * 2];
        System.arraycopy(array,0,newArray,0, size());
        array = newArray;
    }

    @Override
    public int size() {
        return top;
    }



    @Override
    public int get() {
        if (top >= 1){
            return array[--top];
        } else {
            return 0;
        }

//  my solution #1
//        int result = array[--count];
//        int[] newArray = new int[count];
//        newArray = Arrays.copyOf(array, count);
//        array = newArray;
//        return result;
    }

    @Override
    public String asString() {
        return Arrays.toString(Arrays.copyOf(array, size()));
    }
}
