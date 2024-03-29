package VTB.lecture1.homework1;

public class Dog extends Animal {

    static int counter;

    public Dog(String name) {
        super(name);
        counter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance < 500) {
            System.out.println(name + " ran " + distance + " meters.");
        } else {
            System.out.println("Distance " + distance + " is too large for " + name + "!");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 0 && distance < 10) {
            System.out.println(name + " swam " + distance + " meters.");
        } else {
            System.out.println("Distance " + distance + " is too large for " + name + "!");
        }
    }

}
