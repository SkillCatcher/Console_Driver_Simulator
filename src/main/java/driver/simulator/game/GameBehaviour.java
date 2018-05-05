package driver.simulator.game;

import driver.simulator.machines.Vehicle;
import driver.simulator.track.Track;

import java.util.Scanner;

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

    public void display(Vehicle vehicle, Track track) {

        if(track.getLength() <= distanceTraveled) {
            System.out.println("FINISH!!!");
            System.out.println("Your time: " + time + " sec.");
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("So far, " + vehicle.getName() + ", your current distance is " + distanceTraveled
                + " meters, and your time: " + time + " seconds.");
        System.out.println("Your current speed is " + vehicle.getCurrentSpeed() + " meters per second.");
        System.out.println("You've managed to dodge " + obstaclesDodged + " obstacles.");

        if(obstaclesDodged == track.getNumberOfObstacles()) {
            System.out.println("Distance to the finish line: " + (track.getLength() - distanceTraveled) + " meters.");
        } else {
            System.out.println("Distance to your next obstacle: " + distanceFromObstacle[obstaclesDodged]
                    + " meters");
            System.out.println(" ");
            System.out.println("Do you want to dodge?");
            System.out.println("Write 'yes' to dodge - write anything else to not dodge");

            String dodge = scan.next().toLowerCase();

            if(dodge.equals("yes")) {
                if(vehicle.dodge()) {
                    System.out.println("Successful dodge");
                    display(vehicle, track);
                } else {
                    System.out.println("CRASH!!!");
                    return;
                }
            }
        }

        System.out.println("[IF YOU WANT TO ACCELERATE OR DECELERATE, WRITE POSITIVE OR NEGATIVE NUMBER. " +
                "THE BIGGER/LOWER] THE NUMBER, THE BIGGER INCREASE/DECREASE OF ACCELERATION. " +
                "WRITE 0 TO MAINTAIN YOUR CURRENT ACCELERATION");
        System.out.println("Remember - there ARE limits :)");

        double change = scan.nextDouble();

        vehicle.speedChange(change);
        time++;
        distanceTraveled += vehicle.getCurrentSpeed();

        display(vehicle, track);

    }
}
