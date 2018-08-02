package exercises9;

import Pages.AuthenticationPage;
import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.WishListPage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogInTest extends TestShopScenario {

    @Test
    public void LogIn() {

        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Go to login page
        homePage.goTologinPage();

        // Login with provided credentials and check if correct user is logged in
        authenticationPage.logIn("bootcamper@feelthepain.com", "1qazxsw2");
        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains("Seargent Slaughter");
    }
}
