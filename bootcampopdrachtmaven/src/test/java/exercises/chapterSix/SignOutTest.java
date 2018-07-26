package exercises.chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignOutTest {

    @Test
    public void logInSuccessFullAndLogout() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tom.huismans@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("tomtomtom");
        driver.findElement(By.name("SubmitLogin")).click();

        String myProfilePageText = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(myProfilePageText).contains("Welcome to your account");

        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains("tom");

        driver.findElement(By.className("logout")).click();

        WebElement loginButton = driver.findElement(By.className("login"));
        Assertions.assertThat(loginButton.isDisplayed()).as("Login button not visible");
        Assertions.assertThat(loginButton.getText()).as("user is still logged in").contains("Sign in");

        driver.quit();

    }
}
