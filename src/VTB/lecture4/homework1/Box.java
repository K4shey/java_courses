package VTB.lecture4.homework1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> list = new ArrayList<>();

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public float getWeight(){
        float sum = 0;
        for (T element : list) {
            sum += element.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<? extends T> o){
        return (Math.abs(this.getWeight()-o.getWeight()) < 0.0001);
    }

    public void sprinkle (Box<T> box){
        for (T element : list) {
            box.addFruit(element);
        }
        this.list.clear();
    }

}
