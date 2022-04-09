package academy.devonline.java.oop.structures;

import java.util.Arrays;

public class DynaArray extends BaseDataStructure {

    private int[] result = new int[5];

    @Override
    public void add(int value) {

        if (count == result.length) {
//          my first solution :
//           int[] newArray = new int[result.length * 2];
//           int index = 0;
//            for (int element: result) {
//                newArray[index++] = element;
//            }

//          tutor's solution :
//            int[] newArray = new int[result.length * 2];
//            System.arraycopy(result, 0, newArray, 0, result.length);
//            result = newArray;

            int[] newArray = Arrays.copyOf(result, result.length * 2);
            result = newArray;
        }
        result[count++] = value;
    }

    @Override
    public void add(int[] array) {
        add(array, array.length);
    }

    @Override
    public void add(DynaArray array) {
        add(array.result, array.count);
    }

    private void add(int[] array, int length) {
        // my solution
//        int[] newArray = Arrays.copyOf(result, count + length);
//        for (int i = 0; i < length; i++) {
//            newArray[count] = array[i];
//            count++;
//        }
//        result = newArray;
        // tutor's solution
        if (result.length - count < length) {
            grow(count + length);
        }
        System.arraycopy(array, 0, result, count, length);
        count += length;
    }

    private void grow(int newLength) {
        int[] newArray = new int[newLength];
        System.arraycopy(result, 0, newArray, 0, result.length);
        result = newArray;
    }

//    public void add(LinkedList list) {
//        add(list.toArray());
//    }

    public int[] toArray() {
        return Arrays.copyOf(result, count);
    }

    public String asString() {
//        String resultString = "[";
//        for (int i = 0; i < count; i++) {
//            resultString += String.valueOf(result[i]);
//            if (i < count-1) {
//                resultString += " ,";
//            }
//        }
//        resultString += "]";
//        return resultString;

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < count; i++) {
            sb.append(result[i]);
            if (i < count - 1) {
                sb.append(',').append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public boolean remove(int value) {
        // my solution
//        for (int i = 0; i < count; i++) {
//            if (result[i] == value) {
//                count--;
//                int[] newArray = new int[count];
//                for (int j = 0; j < i; j++) {
//                    newArray[j] = result[j];
//                }
//                for (int k = count; k > i; k--) {
//                    newArray[k-1] = result[k];
//                }
//                result = newArray;
//                return true;
//            }
//        }

        // tutor's solution
        int index = indexOf(value);
        if (index != -1) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

    private void removeByIndex(int index) {
        count--;
        if (index < count) {
            for (int i = index; i < count; i++) {
                result[i] = result[i + 1];
            }
        }
    }

    private int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (result[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {

        // my solution
//        for (int element: result) {
//            if (result == value ) {
//                return true;
//            }
//        }
//        return false;

        // tutor's solution
        return indexOf(value) != -1;
    }

}
