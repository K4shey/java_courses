package ForTest.InitializationOfInerfaces;

public class Main {
    public static void main(String[] args) {
        new ClassB(); //создаем объект потомка //(1)
    }

    public static String print(String text) {
        System.out.println(text);
        return text;
    }

    //класс родитель
    public static class ClassA {
        static String a = Main.print("Родитель: Инициализация static а"); //(2)
        String b = Main.print("Родитель: Инициализация b"); //(4)
        String c = Main.print("Родитель: Инициализация c"); //(5)

        public ClassA() {
            Main.print("Родитель: Выполнение конструктора ClassA"); //(6)
        }
    }

    //класс потомок
    public static class ClassB extends ClassA {
        static String d = Main.print("Потомок: Инициализация static d"); //(3)
        String e = Main.print("Потомок: Инициализация e"); //(7)
        String f = Main.print("Потомок: Инициализация f"); //(8)

        public ClassB() {
            Main.print("Потомок: Выполнение конструктора ClassB"); //(9)
        }
    }
}
