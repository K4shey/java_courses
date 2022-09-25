package VTB.lecture4.homework1;

import com.javarush.task.task20.task2018.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDriveHomework1 {

    public static void main(String[] args) {

        String[] firstArray = new String[]{"first", "second", "third", "fourth", "fifth"};
        System.out.println(Arrays.toString(firstArray));
        exchangeElements(firstArray, 0, 4);
        System.out.println(Arrays.toString(firstArray));

        Float[] secondArray = new Float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.5f};
        System.out.println(Arrays.toString(secondArray));
        exchangeElements(secondArray, 1, 3);
        System.out.println(Arrays.toString(secondArray));

        List<String> firstArrayList = convertArrayToArrayList(firstArray);
        System.out.println(firstArrayList.toString());
        List<Float> secondArrayList = convertArrayToArrayList(secondArray);
        System.out.println(secondArrayList.toString());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox.getWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        System.out.println(appleBox.getWeight());
        System.out.println("compare: " + appleBox.compare(appleBox));


    }

    public static <T> List<T> convertArrayToArrayList(T[] array) {
        return Arrays.asList(array);
    }

    public static <T> void exchangeElements(T[] array, int indexFirst, int indexSecond) {
        T temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }

}

