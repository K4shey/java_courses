package VTB.lecture8.homework1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
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
        String result = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(e -> e.getValue()))
                .get()
                .getKey();
        System.out.println(result);

        System.out.println("Average salary is:" + Arrays.stream(persons)
                .mapToDouble(Person::getSalary)
                .average());
        int n = 3;
        if (n <= persons.length) {
            System.out.println(Arrays.stream(persons)
                    .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                    .limit(n)
                    .map(Person::getName)
                    .collect(Collectors.joining(", ", n + " oldest person's name:", ".")));
        } else {
            System.out.println("Too large value of n");
        }
    }

}
