package driver.simulator.game;

import driver.simulator.machines.Vehicle;
import driver.simulator.track.Track;

public class GameBehaviour {

    private int time;
    private double distanceTraveled;
    private double[] distanceFromObstacle;
    private int obstaclesDodged;

    public GameBehaviour(Track track) {
        this.time = 0;
        this.distanceTraveled = 0;
        this.obstaclesDodged = 0;
        this.distanceFromObstacle = new double[track.getNumberOfObstacles()];

        for (int i = 0; i < distanceFromObstacle.length; i++) {
            distanceFromObstacle[i] = track.getObstacles()[i].getPlaceOnTrack();
        }

    }

    public void display(Vehicle vehicle) {
        System.out.println("So far, " + vehicle.getName() + ", your current distance is " + distanceTraveled
                + " meters, and your time: " + time + " seconds.");
        System.out.println("Your current speed is " + vehicle.getCurrentSpeed() + " meters per second.");
        System.out.println("You've managed to dodge " + obstaclesDodged + " obstacles.");
        System.out.println("Distance to your next obstacle: " + distanceFromObstacle[obstaclesDodged]
                + " meters");
        System.out.println(" ");
        System.out.println("What do you want to do?");
    }
}
