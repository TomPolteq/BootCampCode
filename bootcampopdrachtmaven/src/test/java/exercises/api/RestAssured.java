package exercises.api;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

public class RestAssured {

    @Test
    public void getStatusOfUrl(){

        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").then().statusCode(200);

        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("max_verstappen"));

    }

}
