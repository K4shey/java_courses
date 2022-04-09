package academy.devonline.java.oop.section031_polymorphism;

public class GetClassUsage {
    public static void main(String[] args) {
//        Object o = new Parent();
        Object o = new Child();

        boolean result = o instanceof Child;
        System.out.println(result);
//        System.out.println(o instanceof Child);
        System.out.println(o instanceof Object);
        if (o instanceof Child) {
            System.out.println("Child");
        }
    }

    private static class GrandParent /*extends Object*/ {

    }

    private static class Parent extends GrandParent {

    }

    private static class Child extends Parent {

    }
}
