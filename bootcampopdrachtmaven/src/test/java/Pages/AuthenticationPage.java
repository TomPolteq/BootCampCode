package Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void logIn(String username, String password) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("SubmitLogin")).click();
        Assertions.assertThat(driver.findElement(By.className("info-account")).isDisplayed());
        String myProfilePageText = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(myProfilePageText).contains("Welcome to your account");
    }
}

