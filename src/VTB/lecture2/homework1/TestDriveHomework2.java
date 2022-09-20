package VTB.lecture2.homework1;

public class TestDriveHomework2 {


    public static void main(String[] args) {
        Cat cat = new Cat("Smokey", 20, 2);
        Human human = new Human("Boris", 100, 1);
        Robot robot = new Robot("Bender", 200, 3);
        Movable[] arrayCreatures = new Movable[]{cat, human, robot};
        Wall wall = new Wall(2);
        Track track = new Track(20);
        Obstacle[] arrayObstacles = new Obstacle[]{wall, track};
        for (Movable movable : arrayCreatures) {
            for (Obstacle obstacle : arrayObstacles) {
                if (obstacle.getLength() > 0) {
                    if (movable.run(obstacle.getLength()) == false) {
                        break;
                    }
                }
                if (obstacle.getHeight() > 0) {
                    if (movable.jump(obstacle.getHeight()) == false) {
                        break;
                    }
                }
            }
        }
    }
}
