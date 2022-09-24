package VTB.lecture4.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDriveHomework1 {

    public static void main(String[] args) {

        GenericArray<String> firstArray = new GenericArray<>("first", "second", "third", "fourth", "fifth");
        System.out.println(firstArray.toString());
        firstArray.exchangeElements(0,4);
        System.out.println(firstArray.toString());

        GenericArray<Float> secondArray = new GenericArray<>(1.0f, 2.0f, 3.0f, 4.0f, 5.5f);
        System.out.println(secondArray.toString());
        secondArray.exchangeElements(1,3);
        System.out.println(secondArray.toString());

        List<String> firstArrayList = convertArrayToArrayList(firstArray.getArray());
        System.out.println(firstArrayList.toString());
        List<Float> secondArrayList = convertArrayToArrayList(secondArray.getArray());
        System.out.println(secondArrayList.toString());

    }

    public static <T> List<T> convertArrayToArrayList(T[] array){
        return Arrays.asList(array);
    }

}

