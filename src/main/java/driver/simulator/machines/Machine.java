package driver.simulator.machines;

public class Machine {

    private String name;
    private double currentSpeed;
    private double maxSpeed;
    private double acceleration;
    private double maxAcceleration;
    private double breaksForce;

    public String getName() {
        return name;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public double getBreaksForce() {
        return breaksForce;
    }

    public Machine(String name, double maxSpeed, double maxAcceleration, double breaksForce) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxAcceleration = maxAcceleration;
        this.acceleration = 0.0;
        this.currentSpeed = 0.0;
        this.breaksForce = breaksForce;
    }

    private void speedUp(double accelerate) {
        if(acceleration + accelerate > maxAcceleration) {
            acceleration = maxAcceleration;
        } else if(acceleration + accelerate < breaksForce*(-1)) {
            acceleration = breaksForce*(-1);
        } else {
            acceleration += accelerate;
        }
    }

    public void speedChange(double accelerate) {
        speedUp(accelerate);
        if(currentSpeed + acceleration > maxSpeed) {
            currentSpeed = maxSpeed;
        } else if(currentSpeed + acceleration < 0) {
            currentSpeed = 0;
        } else {
            currentSpeed += acceleration;
        }
    }
}
