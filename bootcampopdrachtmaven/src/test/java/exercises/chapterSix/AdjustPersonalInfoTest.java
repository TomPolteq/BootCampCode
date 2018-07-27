package exercises.chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AdjustPersonalInfoTest extends TestShopScenario {

    @Test
    public void adjustPersonalInfo() throws InterruptedException {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tom.huismans@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("tomtomtom");
        driver.findElement(By.name("SubmitLogin")).click();

        String myProfilePageText = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(myProfilePageText).contains("Welcome to your account");

        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains("tom");

        driver.findElement(By.className("icon-user")).click();
        WebElement headerPersonalPage = driver.findElement(By.className("page-subheading"));
        Assertions.assertThat(headerPersonalPage.getText()).as("Incorrect page is open").contains("YOUR PERSONAL INFORMATION");
        WebElement firstName = driver.findElement(By.xpath(".//*[@id='firstname']"));
        String newName;
         if (firstName.getText().contains("Tom")) {
            firstName.clear();
            newName = "Piet";
        } else {
            firstName.clear();
            newName = "Tom";
        }

        firstName.sendKeys(newName);
        driver.findElement(By.id("old_passwd")).sendKeys("tomtomtom");
        driver.findElement(By.xpath(".//*[@name='submitIdentity']")).click();

        driver.findElement(By.xpath(".//*[@class='navigation_page'][1]")).click();
        driver.findElement(By.className("icon-user")).click();

        Assertions.assertThat(driver.findElement(By.xpath(".//*[@id='firstname']")).getAttribute("value")).as("Confirm namechange").isEqualTo(newName);

    }
}
