package VTB.lecture1.homework1;

public abstract class Animal {
    protected String name;
    static int counter;

    public Animal(String name) {
        this.name = name;
        counter++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

}
