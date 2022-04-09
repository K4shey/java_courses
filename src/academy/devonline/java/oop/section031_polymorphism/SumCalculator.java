package academy.devonline.java.oop.section031_polymorphism;

public class SumCalculator {
    public static void main(String[] args) {

//       ArrayElementsProvider arrayProvider = new FromRAMArrayElementsProvider(new int[] {1, 2, 3, 4, 5});
       ArrayElementsProvider arrayProvider = new FromClasspathResourceArrayElementsProvider("data.txt");

        System.out.println(sum(arrayProvider));
    }

    public static long sum(ArrayElementsProvider provider){

        long sum = 0;

        while (provider.hasMoreElements()){
            sum +=provider.nextElement();
        }
        return sum;
    }

}
