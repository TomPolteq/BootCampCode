package exercises;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Controles {
    @Test
    public void assertNumber(){
        int temperature = 49;
        Assertions.assertThat(temperature).as("Het is nog geen 50 graden").isGreaterThan(50);
    }
    @Test
    public void assertString() {
        String outside = "bloedheet";
        Assertions.assertThat(outside).contains("fris");
    }

    @Test
    public void trueOrFalse(){
        boolean hitteplan = false;
        Assertions.assertThat(hitteplan).as("Hitteplan niet van start").isTrue();
    }
}
