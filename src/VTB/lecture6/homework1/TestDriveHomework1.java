package VTB.lecture6.homework1;

import java.util.Arrays;

public class TestDriveHomework1 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        calculateOneThread();
        calculateTwoThreads();
    }

    public static void calculateOneThread() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void calculateTwoThreads() throws InterruptedException {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);
        long start = System.currentTimeMillis();
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];
        System.arraycopy(array, 0, array1, 0, HALF);
        System.arraycopy(array, HALF, array2, 0, HALF);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                            * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    array2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                            * Math.cos(0.4f + i / 2));
                }

            }
        });
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(array1, 0, array, 0, HALF);
        System.arraycopy(array2, 0, array, HALF, HALF);

        System.out.println(System.currentTimeMillis() - start);
    }

}
