package VTB.lecture2.homework1;

public class Robot implements Movable {

    private final String name;
    private final int runLength;
    private final int jumpHeight;

    public Robot(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    @Override
    public boolean run(int distance) {
        boolean success = false;
        if (runLength >= distance) {
            System.out.println("Robot " + name + " ran " + distance + " meters.");
            success = true;
        } else {
            System.out.println("Robot " + name + " didn't ran " + distance + " meters. Too large distance.");
        }

        return success;
    }

    @Override
    public boolean jump(int height) {
        boolean success = false;
        if (jumpHeight >= height) {
            System.out.println("Robot " + name + " jumped " + height + " meters.");
            success = true;
        } else {
            System.out.println("Robot " + name + " didn't jump " + height + " meters. Too large height.");
        }

        return success;
    }

}
