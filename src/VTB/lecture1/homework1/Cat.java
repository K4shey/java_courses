package VTB.lecture1.homework1;

public abstract class Cat extends Animal {

    static int counter;

    public Cat(String name) {
        super(name);
//        catCounter++;
    }
    public abstract void run(int distance);
    public abstract void swim(int distance);
//    @Override
//    public void run(int distance) {
//        if (distance > 0 && distance < 200) {
//            System.out.println(name + " ran " + distance + " meters.");
//        } else {
//            System.out.println("Distance " + distance + " is too large for " + name + "!");
//        }
//    }
//
//    @Override
//    public void swim(int distance) {
//        System.out.println("Cats can't swim!");
//    }
}
