package academy.devonline.java.oop.structures;

public class DataStorageTest {

    public static void main(String[] args) {

//        DataStorage structure = new QueueBasedOnArray();
//        BasedOnArrayDataStorage structure = new QueueBasedOnArray();

//        DataStorage structure = new StackBasedOnArray();
//        BasedOnArrayDataStorage structure = new StackBasedOnArray();

//        DataStorage structure = new QueueBasedOnLinkedList();
        DataStorage structure = new StackBasedOnLinkedList();

        for (int i = 1; i <= 6; i++) {
            structure.add(i);
        }
        System.out.println(structure.asString());

        while (structure.size() > 0) {
            System.out.print(structure.get() + " ");
        }
//        for (int i = 0; i < 8; i++) {
//            System.out.print(structure.get() + " ");
//        }

    }

}
