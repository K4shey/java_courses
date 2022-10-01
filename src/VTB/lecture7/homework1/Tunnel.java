package VTB.lecture7.homework1;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    public static Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT/2);

    public Tunnel() {
        length = 80;
        description = "Туннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            semaphore.acquire();
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            System.out.println(c.getName() + " начал этап " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап " + description);
            semaphore.release();
        }
    }
}
