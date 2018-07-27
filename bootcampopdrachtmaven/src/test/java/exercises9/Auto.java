package exercises9;

public class Auto {

    public void setColor(String carColor) {
        System.out.println("The color of your car is " + carColor);
    }

    public void setBrand(String carBrand) {
        System.out.println("The brand of your car is " + carBrand);
    }

    public void setMotorType(String carMotorType) {
        System.out.println("The car has a " + carMotorType + " engine");
    }

    public void setCarDoors(Integer carDoors) {
        System.out.println("The car has " + carDoors + " Doors");
    }

    public void calculateTorque(int force, int engine) {
        int multiplier = 5252;
        System.out.println("Amount of Torque of the car is "+ (force * multiplier) / engine);
    }
}

