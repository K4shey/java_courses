package VTB.lecture7.homework1;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        description = "Дорога " + this.length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап " + description);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}
