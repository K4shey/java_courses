package ForTest.InitializationOfInerfaces;

public class Animal {

    String brain = "Изначальное значение brain в классе Animal"; //(4)
    String heart = "Изначальное значение heart в классе Animal"; //(5)

    public static int animalCount = 7700000; //(2)

    public Animal(String brain, String heart) { //(6)
        System.out.println("Выполняется конструктор базового класса Animal");
        System.out.println("Были ли уже проинициализированы переменные класса Animal?");
        System.out.println("Текущее значение статической переменной animalCount = " + animalCount);
        System.out.println("Текущее значение brain в классе Animal = " + this.brain);
        System.out.println("Текущее значение heart в классе Animal = " + this.heart);
        System.out.println("Были ли уже проинициализированы переменные класса Cat?");
        System.out.println("Текущее значение статической переменной catsCount = " + Cat.catsCount);

        this.brain = brain;
        this.heart = heart;
        System.out.println("Конструктор базового класса Animal завершил работу!");
        System.out.println("Текущее значение brain = " + this.brain);
        System.out.println("Текущее значение heart = " + this.heart);
    }
}

class Cat extends Animal {

    String tail = "Изначальное значение tail в классе Cat"; //(7)

    static int catsCount = 37; //(3)

    public Cat(String brain, String heart, String tail) {  //(8)
        super(brain, heart);
        System.out.println("Конструктор класса Cat начал работу (конструктор Animal уже был выполнен)");
        System.out.println("Текущее значение статической переменной catsCount = " + catsCount);
        System.out.println("Текущее значение tail = " + this.tail);
        this.tail = tail;
        System.out.println("Текущее значение tail = " + this.tail);
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Мозг", "Сердце", "Хвост"); //(1)
    }
}