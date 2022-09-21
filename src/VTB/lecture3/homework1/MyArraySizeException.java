package VTB.lecture3.homework1;

//public class MyArraySizeException extends RuntimeException {
    public class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
