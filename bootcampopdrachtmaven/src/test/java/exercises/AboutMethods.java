package exercises;

import org.testng.annotations.Test;

public class AboutMethods {
    private int multiply(int getal1, int getal2) {
        return getal1 * getal2;
    }

    @Test
    public void printProduct() {
        System.out.println(multiply(5,4));
    }
}

