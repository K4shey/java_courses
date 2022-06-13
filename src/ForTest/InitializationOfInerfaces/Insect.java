package ForTest.InitializationOfInerfaces;

class Insect {
    private int i = 9; //(6)
    protected int j; //(7)
    Insect() { //(8)
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized"); //(1)
    static int printInit(String s) { //(2)
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized"); //(9)
    public Beetle() { //(10)
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized"); //(3)
    public static void main(String[] args) { //(4)
        System.out.println("Beetle constructor"); //(5)
        Beetle b = new Beetle();
    }
}



    /**Инициализация полей классов при наследовании происходит в следующем порядке:

        Статические поля класса Parent
        Статический блок инициализации класса Parent
        Статические поля класса Child
        Статический блок инициализации класса Child
        Нестатические поля класса Parent
        Нестатический блок инициализации класса Parent
        Конструктор класса Parent
        Нестатические поля класса Сhild
        Нестатический блок инициализации класса Сhild
        Конструктор класса Сhild
**/
