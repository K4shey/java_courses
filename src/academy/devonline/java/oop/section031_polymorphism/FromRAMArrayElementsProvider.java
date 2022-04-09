package academy.devonline.java.oop.section031_polymorphism;

public class FromRAMArrayElementsProvider implements ArrayElementsProvider{

    int[] innerArray;
    int index;

    public FromRAMArrayElementsProvider(int[] innerArray) {
        this.innerArray = innerArray;
    }


    @Override
    public boolean hasMoreElements(){
        return index < innerArray.length;
    }

    @Override
    public int nextElement(){
        return innerArray[index++];
    }
}
