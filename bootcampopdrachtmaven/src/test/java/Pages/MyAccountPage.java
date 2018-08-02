package Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {


    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWishListPage() {
        driver.findElement(By.className("icon-heart")).click();
        WebElement headerWishListPage = driver.findElement(By.className("page-heading"));
        Assertions.assertThat(headerWishListPage.getText()).as("Incorrect page is open").contains("MY WISHLISTS");
    }
}
