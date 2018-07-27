package exercises.chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void adjustSuppliersInfo() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@name='supplier_list']")).click();
        Select dropdown = new Select(driver.findElement(By.name("supplier_list")));
        dropdown.selectByVisibleText("AppleStore");

        String productListText = driver.findElement(By.xpath(".//*[@class='page-heading product-listing']")).getText();
        Assertions.assertThat(productListText).contains("LIST OF PRODUCTS BY SUPPLIER: APPLESTORE");

        String productName = "MacBook Air";
        List<WebElement> allProducts = driver.findElements(By.cssSelector("[id='center_column'] [class='product-name']"));
        List<String> productlist = new ArrayList<String>();

        boolean productFound = false;

        for (WebElement element : allProducts) {
            if (element.getText().contains(productName)) {
                System.out.println(element.getText());
                productFound = true;
                break;
            }
        }
        Assertions.assertThat(productFound).as("Product not found").isTrue();
    }
}