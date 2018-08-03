package exercises.dataDriven;

import Pages.AuthenticationPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenLogInTest extends TestShopScenario {

    @Parameters ({"username", "password", "userValidation"})
    @Test
    public void LogIn(String username, String password, String userValidation) {

        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Go to login page
        homePage.goTologinPage();

        // Login with provided credentials and check if correct user is logged in
        authenticationPage.logIn(username,password);
        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains(userValidation);
    }
}
