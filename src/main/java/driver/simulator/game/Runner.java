package driver.simulator.game;

import driver.simulator.machines.Vehicle;
import driver.simulator.track.Track;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        System.out.println("Welcome to the BlackCarJack");
        System.out.println(" ");
        System.out.println("Dodge the obstacles on the track at closest distance and highest speed possible," +
                " but remember - you don't get points for crashing, even in style ;)");

        System.out.println(" ");
        System.out.println("Are you ready?");
        System.out.println("[IF YOU ARE, WRITE YOUR NAME IN THE CONSOLE, THEN PRESS ENTER]");

        Scanner skan = new Scanner(System.in);
        String name = skan.next();

        Vehicle player = new Vehicle(name, 100, 40, 40);
        Track currentTrack = new Track(1000, 0);
        currentTrack.setObstacles();

        GameBehaviour game = new GameBehaviour(currentTrack);
        game.display(player, currentTrack);


    }
}
