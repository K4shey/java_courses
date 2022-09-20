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
            System.out.println(String.format("%s running %d meters.",  this.toString() , distance));
            success = true;
        } else {
            System.out.println(String.format("%s didn't ran %d meters. Too large distance.",  this.toString() , distance));
        }

        return success;
    }

    @Override
    public boolean jump(int height) {
        boolean success = false;
        if (jumpHeight >= height) {
            System.out.println(String.format("%s jumping %d meters.",  this.toString() , height));
            success = true;
        } else {
            System.out.println(String.format("%s didn't jumped %d meters.",  this.toString() , height));
        }
        return success;
    }

    @Override
    public String toString(){
        return "Robot " + name;
    }

}
