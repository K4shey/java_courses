package VTB.lecture1.homework1;

public class TestDriveHomeWork1 {
    public static void main(String[] args) {

        int dogCount = 0;
        int catCount = 0;

        Animal[] zoo = new Animal[]{
                new Dog("Cooper"),
                new Dog("Buster"),
                new DomesticCat("Smokey"),
                new DomesticCat("Gracie"),
                new Tiger("Shere Khan")

        };

        for (Animal animal : zoo) {

            animal.run(100);
            animal.swim(3);
        }

        System.out.println(Dog.counter + " dogs was processed");
        System.out.println(DomesticCat.counter + " cats was processed");
        System.out.println(Tiger.counter + " tigers was processed");
        System.out.println(Animal.counter + " animals was processed");

    }
}
