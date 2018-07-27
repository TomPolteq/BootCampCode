package exercises9;

import org.testng.annotations.Test;

public class TestAutoClass {

    @Test
    public void createAuto() {
    Auto auto1 = new Auto();
    auto1.setBrand("Audi");
    auto1.setColor("Blue");
    auto1.setMotorType("Diesel");
    auto1.setCarDoors(5);
    auto1.calculateTorque(110, 4000);

    AutoAdvanced auto2 = new AutoAdvanced("Volvo",5,10);

    }

}
