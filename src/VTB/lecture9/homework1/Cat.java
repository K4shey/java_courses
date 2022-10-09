package VTB.lecture9.homework1;

@Table(title = "cats")
public class Cat {
    @Column
    String name;
    @Column
    double weight;
    @Column
    int age;

    public Cat(String name, double weight, int age) {

        this.name = name;
        this.weight = weight;
        this.age = age;
    }
}
