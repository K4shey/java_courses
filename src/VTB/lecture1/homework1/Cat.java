package VTB.lecture1.homework1;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance < 200) {
            System.out.println(name + " ran " + distance + " meters.");
        } else {
            System.out.println("Distance " + distance + " is too large for " + name + "!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats can't swim!");
    }
}
