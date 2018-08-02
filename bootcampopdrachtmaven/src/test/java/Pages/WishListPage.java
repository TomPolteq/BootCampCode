package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WishListPage {


    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkExistingOfWishlist(String product) {
        List<WebElement> allLists = driver.findElements(By.xpath(".//table//tbody/tr/td/a"));
        List<String> wishList = new ArrayList<String>();

        for (WebElement element : allLists) {
            wishList.add(element.getText());
        }
        return wishList.contains(product);
    }

    public void createNewWishList(String productName) {
        driver.findElement(By.cssSelector(".inputTxt.form-control")).sendKeys(productName);
        driver.findElement(By.id("submitWishlist")).click();
        System.out.println("New wishlist created with name " + " " + productName);
    }

    public void removeWishList(String wishlistName) {
        String idOfTheTableRow = driver.findElement(By.xpath(".//A[@href='#'][text()='" + " " + wishlistName + " " + "']/ancestor::tr")).getAttribute("id");
        System.out.println(idOfTheTableRow + " has been found and will be deleted");
        driver.findElement(By.xpath("//tr[@id='" + idOfTheTableRow + "']/td[@class='wishlist_delete']/a")).click();
        driver.switchTo().alert().accept();
    }

    public void goToProfilePage() {

        driver.findElement(By.className("account")).click();
    }
}
