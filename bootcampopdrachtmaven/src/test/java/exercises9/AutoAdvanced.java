package exercises9;

public class AutoAdvanced {

    public String brand;
    public int force;
    public int engine;

    public AutoAdvanced(String brand, int force, int engine){
        int multiplier = 5252;
        this.brand = brand;
        this.engine = engine;
        this.force = force;
        System.out.print("Brand of your car is " + brand + " and has " + calculateTorque(force, engine) + " torque");
    }

    public int calculateTorque(int force, int engine) {
        int multiplier = 5252;
        return (force * multiplier) / engine;
    }
}
