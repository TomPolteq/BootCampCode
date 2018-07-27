package exercises.chapterSix;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class xpathLocator extends TestShopScenario{
    @Test
    public void adjustSuppliersInfo() throws InterruptedException {
        driver.findElement(By.xpath("//ul/li[3]/a[@title='Accessories']")).click();
    }
}

