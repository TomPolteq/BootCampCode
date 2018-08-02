package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goTologinPage() {
        driver.findElement(By.className("login")).click();
    }
}
