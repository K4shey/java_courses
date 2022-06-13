package ForTest.InitializationOfInerfaces;

public interface Study {

    Exam exam = new Exam();
    void learn();
    default void haveFun() {
        System.out.println("Party all the night!");
    }
    class Exam {
        Exam(){
            System.out.println("2");
            System.out.println("\nI'm ready to study!" +
                    "But let me sleep a little bit more");
        }
    }
}
