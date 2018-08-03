package exercises.dataDriven;

import Pages.AuthenticationPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class DataDrivenLogInTestCsv extends TestShopScenario {

    //Provide CSV file path. It Is In D: Drive.
    String CSV_PATH = "C:\\Users\\Gebruiker\\Desktop\\InlogData.csv";

    @Test
    public void LogIn() throws IOException {

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            String username = csvCell[0];
            String password = csvCell[1];
            String userValidation = csvCell[2];

            HomePage homePage = new HomePage(driver);
            AuthenticationPage authenticationPage = new AuthenticationPage(driver);

            // Go to login page
            homePage.goTologinPage();

            // Login with provided credentials and check if correct user is logged in
            authenticationPage.logIn(username, password);
            String welcomeElement = driver.findElement(By.className("account")).getText();
            Assertions.assertThat(welcomeElement).as("user is not logged in").contains(userValidation);
        }
    }
}
