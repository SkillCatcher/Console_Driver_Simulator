package driver.simulator.machines;

public class Machine {

    private boolean isAccesible;
    private boolean isBroken;

    public boolean isAccesible() {
        return isAccesible;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setAccesible(boolean accesible) {
        isAccesible = accesible;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public Machine() {
        this.isAccesible = true;
        this.isBroken = false;
    }

    public void getIn(String name) {
        if(isAccesible && !isBroken) {
            this.isAccesible = false;
            System.out.println("You got in the " + name);
        } else {
            System.out.println(name + " is not accesible or broken. Please choose another machine.");
        }
    }

    public void getOut(String name) {
        System.out.println("You got out of " + name);
    }

    public void fix(String name) {
        if(isBroken) {
            this.isBroken = false;
            System.out.println("You have successfully repaired the " + name + ". Now you can use it.");
        } else {
            System.out.println(name + " is not broken. Chill out...");
        }
    }
}
