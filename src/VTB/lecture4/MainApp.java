package VTB.lecture4;

public class MainApp {
    public static void main(String[] args) {
        TestGeneric<String> testGenericStr = new TestGeneric<>("Java");
        testGenericStr.getType();
        System.out.println("getObj:" + testGenericStr.getObj() + " " + testGenericStr.getObj().getClass().getSimpleName());
        TestGeneric<Integer> testGenericInt = new TestGeneric<>(122);
        testGenericInt.getType();
        System.out.println("getObj:" + testGenericInt.getObj() + " " + testGenericInt.getObj().getClass().getSimpleName());

        String valueFromTestGenericStr = testGenericStr.getObj();
        Integer valueFromTestGenericInt = testGenericInt.getObj();
//        testGenericInt.setObj("Test"); Не скомпилируюется, т.к. ожидается значение типа Integer
    }
}

class TestGeneric<T> {
    private T obj;

    public TestGeneric(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void getType() {
        System.out.println("Type T: " + obj.getClass().getName());
    }
}