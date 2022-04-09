package academy.devonline.java.oop.structures;

import java.util.Arrays;

public class QueueBasedOnArrayMine implements DataStorage{

   private int[] array = new int[5];
//   private int count;
    private int head;
    private int tail;

    @Override
    public void add(int value) {
        if (size()!=0 && tail == size() ){
            increase();
        }
        array[tail] = value;
        tail++;
//  my solution #1
//        int[] newArray = new int[++count];
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
        return tail-head;
//  my solution #1
//        return count;
    }

    @Override
    public int get() {
        if(head <= tail) {
            int result = array[head];
            head++;
            return result;
        } else {
            // TODO Exception
            return 0;
        }


//  my solution #1
//        int result = array[0];
//        int[] newArray = new int[--count];
//        System.arraycopy(array, 1, newArray, 0, count);
//        array = newArray;
//        return result;
    }

    @Override
    public String asString(){
        //  my solution #1
        //return Arrays.toString(array);
        return Arrays.toString((Arrays.copyOf(array, size())));
    }
}
