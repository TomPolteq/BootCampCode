package exercises.api;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class PathParaTest {

    @Test
    public void pathParaTest(){
        int year = 2017;
        given().pathParam("season", year).when().get("http://ergast.com/api/f1/{season}/drivers/max_verstappen/results.json").
              then().assertThat().body("MRData.RaceTable.driverId", containsString("max_verstappen"));

        given().pathParam("season", year).when().get("http://ergast.com/api/f1/{season}/drivers/alonso/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("alonso"));

    }
}
