package exercises.chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCartTest {

    @Test
    public void fillCartMethod() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        WebElement basketContent = driver.findElement(By.className("ajax_cart_no_product"));
        Assertions.assertThat(basketContent.isDisplayed()).as("Cart is not empty");
        Assertions.assertThat(basketContent.getText()).as("there are products in the basket").contains("(empty)");

        driver.findElement(By.cssSelector(".tag_level3.first_item")).click();
        driver.findElement(By.xpath(".//*[@title='iPod shuffle']")).click();

        driver.findElement(By.id("add_to_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@title='Continue shopping']")));
        driver.findElement(By.xpath(".//*[@title='Continue shopping']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ajax_cart_quantity unvisible']")));

        WebElement cartItems = driver.findElement(By.xpath(".//*[@class='ajax_cart_quantity unvisible']"));
        Assertions.assertThat(cartItems.getText()).as("no items in cart").contains("1");
        Assert.assertEquals(cartItems.getText(),"1");
        driver.quit();
    }
}
