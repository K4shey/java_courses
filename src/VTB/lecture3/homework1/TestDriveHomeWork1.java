package VTB.lecture3.homework1;

public class TestDriveHomeWork1 {

    public static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        String[][] array1 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] array2 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4rr"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] array3 = new String[][]{
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "6"},
                {"1", "2", "3", "4", "7"},
                {"1", "2", "3", "4", "8"},
        };
        try {
            System.out.println("Processing first array:");
            System.out.println("Sum = " + checkArray(array1));
        } catch (MyArrayDataException | MyArraySizeException made) {
            System.out.println(made.getMessage());
        }

        try {
            System.out.println("Processing second array:");
            System.out.println("Sum = " + checkArray(array2));
        } catch (MyArrayDataException | MyArraySizeException made) {
            System.out.println(made.getMessage());
        }

        try {
            System.out.println("Processing third array:");
            System.out.println("Sum = " + checkArray(array3));
        } catch (MyArrayDataException | MyArraySizeException made) {
            System.out.println(made.getMessage());
        }

    }

    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array == null) {
            throw new MyArraySizeException("Array is empty");
        }
        if (array.length > ARRAY_SIZE) {
            throw new MyArraySizeException("Exceeded max size of rows");
        } else if (array[0].length > ARRAY_SIZE) {
            throw new MyArraySizeException("Exceeded max size of columns");
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }
            }
        }
        return result;
    }
}
