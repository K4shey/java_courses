package VTB.lecture3.homework1;

public class MyArrayDataException extends Exception {

    private int row;
    private int col;
    private String value;


    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException() {
    }

    public MyArrayDataException(int row, int col, String value) {
        super("Wrong data in position [" + row + "," + col + "] = " + value);
        this.row = row;
        this.col = col;
        this.value = value;
    }

}
