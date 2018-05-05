package driver.simulator.track;

public class Track {

    private double length;
    private int numberOfObstacles;
    private Obstacle[] obstacles;

    public double getLength() {
        return length;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    public Track(double length, int numberOfObstacles) {
        this.length = length;
        this.numberOfObstacles = numberOfObstacles;
        this.obstacles = new Obstacle[numberOfObstacles];
    }

    public void setObstacles() {
        Obstacle[] obstacles = new Obstacle[numberOfObstacles];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Obstacle(Math.round(Math.random()*length));
        }

        this.obstacles = obstacles;
    }
}
