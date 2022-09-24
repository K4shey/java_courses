package VTB.lecture4.homework1;

public class GenericArray<T> {

    private T[] array;

    public GenericArray(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void exchangeElements(int indexFirst, int indexSecond) {
        T temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i].toString());
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
