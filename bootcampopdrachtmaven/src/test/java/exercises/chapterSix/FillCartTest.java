package exercises.chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FillCartTest {

    @Test
    public void fillCartMethod() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        WebElement basketContent = driver.findElement(By.className("ajax_cart_no_product"));
        basketContent.isDisplayed();
        Assertions.assertThat(basketContent.getText()).as("there are products in the basket").contains("(empty)");



        driver.quit();
    }
}
