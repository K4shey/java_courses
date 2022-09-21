package VTB.lecture2.homework1;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height){
        this.height = height;
    }

    public boolean contest(Movable creature) {
        boolean result = false;
        if (creature.jump(height)) {
            System.out.println(String.format("%s successfully jump a distance %d meters.",  creature , height));
            result = true;
        } else {
            System.out.println(String.format("%s was failed on jumping a distance %d meters.",  creature , height));

        }
        return result;
    }
}
