package VTB.lecture2.homework1;

public class Track extends Obstacle{

    private int length;

    public Track(int length){
        this.length = length;
    }

    public boolean contest(Movable creature) {
        boolean result = false;
        if (creature.run(length)) {
            System.out.println(String.format("%s successfully ran a distance %d meters.",  creature , length));
            result = true;
        } else {
            System.out.println(String.format("%s was failed on a distance %d meters.",  creature , length));
        }
        return result;
    }
}
