package VTB.lecture1.homework1;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

}
