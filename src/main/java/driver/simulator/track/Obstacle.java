package driver.simulator.track;

public class Obstacle {

    private double placeOnTrack;
    private boolean isDodged;

    public double getPlaceOnTrack() {
        return placeOnTrack;
    }

    public boolean isDodged() {
        return isDodged;
    }

    public Obstacle(double placeOnTrack) {
        this.placeOnTrack = placeOnTrack;
        this.isDodged = false;
    }
}
