package VTB.lecture8.homework1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestDriveHomework1 {

    public static void main(String[] args) {

        Person[] persons = new Person[]{
                new Person("Jimmy", 22, 3000),
                new Person("Frank", 26, 3500),
                new Person("Gottfrid", 29, 4500),
                new Person("Robby", 32, 1500),
                new Person("Otto", 34, 5500),

        };

        String[] words = new String[]{"Cat", "Dog", "Bear", "Monkey", "Rabbit", "Donkey", "Dog", "Rabbit", "Donkey", "Dog"};
        System.out.println("the most frequent word is:");
        Arrays.stream(words)
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((w1, w2) -> (int) (w2.getValue() - w1.getValue())).limit(1).forEach(System.out::println);

        System.out.println("Average salary is:" + Arrays.stream(persons).collect(Collectors.averagingDouble(Person::getSalary)));
        int n = 5;
        if (n <= persons.length) {
            System.out.println(n + " oldest person's names:");
            Arrays.stream(persons).sorted((p1, p2) -> p2.getAge() - p1.getAge()).limit(n).forEach(p -> System.out.println(p.getName()));
        } else {
            System.out.println("Too large value of n");
        }

    }

}
