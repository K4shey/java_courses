package VTB.lecture7.homework1;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore semaphore;

    public Tunnel() {
        length = 80;
        description = "Туннель " + length + " метров";
        this.semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {
        try {
            semaphore.acquire();
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            System.out.println(c.getName() + " начал этап " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            System.out.println(c.getName() + " закончил этап " + description);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
