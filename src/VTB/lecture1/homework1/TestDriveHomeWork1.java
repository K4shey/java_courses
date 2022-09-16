package VTB.lecture1.homework1;

public class TestDriveHomeWork1 {
    public static void main(String[] args) {

        int dogCount = 0;
        int catCount = 0;

        Animal[] zoo = new Animal[]{
                new Dog("Cooper"),
                new Dog("Buster"),
                new Cat("Smokey"),
                new Cat("Gracie")
        };

        for (Animal animal : zoo) {

            if (animal instanceof Cat) {
                catCount++;
            } else if (animal instanceof Dog) {
                dogCount++;
            }

            animal.run(100);
            animal.swim(3);
        }

        System.out.println(dogCount + " dogs was processed");
        System.out.println(catCount + " cats was processed");

    }
}
