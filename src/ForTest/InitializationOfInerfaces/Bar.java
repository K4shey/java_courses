package ForTest.InitializationOfInerfaces;

public abstract class Bar {
    private String name;
    static {
        System.out.println("Bar:static 1"); //(1)
    }
    {
        System.out.println("Bar:instance 1"); //(5), (12?)
    }
    static {
        System.out.println("Bar:static 2"); //(2)
    }
    public Bar() {
        System.out.println("Bar:constructor"); //(7)
    }
    {
        System.out.println("Bar:instance 2"); //(6), (13?)
    }
    public Bar(String name) {
        this.name = name;
        System.out.println("Bar:name-constructor"); //(14)
    }
}
 class Foo extends Bar {
    static {
        System.out.println("Foo:static 1"); //(3)
    }
    {
        System.out.println("Foo:instance 1"); //(8), (15?)
    }
    static {
        System.out.println("Foo:static 2"); //(4)
    }
    public Foo() {
        System.out.println("Foo:constructor"); //(10)
    }
    public Foo(String name) {
        super(name);
        System.out.println("Foo:name-constructor");//(17)
    }
    {
        System.out.println("Foo:instance 2"); //(9), (16?)
    }
    public static void main(String... args) {
        new Foo();
        System.out.println(); //(11);
        new Foo("Baz");
    }
}