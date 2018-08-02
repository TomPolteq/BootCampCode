package exercises.chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveWishList2 extends TestShopScenario {


    @Test
    public void removeAndAddWishList() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tom@huismans.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.name("SubmitLogin")).click();

        String myProfilePageText = driver.findElement(By.className("info-account")).getText();
        Assertions.assertThat(myProfilePageText).contains("Welcome to your account");

        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains("Tom");

        driver.findElement(By.className("icon-heart")).click();
        WebElement headerWishListPage = driver.findElement(By.className("page-heading"));
        Assertions.assertThat(headerWishListPage.getText()).as("Incorrect page is open").contains("MY WISHLISTS");

        // vanaf hier is het een groot probeersel

        String productName = "No Pain No Gain";
        String idOfTheTableRow;
        boolean correctWishList = false;
        Thread thread;
        String removeButton = driver.findElement(By.className("icon-remove")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 150);

        List<WebElement> allLists = driver.findElements(By.xpath(".//table//tbody/tr/td/a"));
        List<String> wishlist = new ArrayList<String>();

        for (WebElement element : allLists) {
            wishlist.add(element.getText());

            if (element.getText().contains(productName)) {
                idOfTheTableRow = driver.findElement(By.xpath(".//A[@href='#'][text()=' No Pain No Gain ']/ancestor::tr")).getAttribute("id");
                System.out.println(idOfTheTableRow + " has been found and will be deleted");
                correctWishList = true;
                driver.findElement(By.xpath("//tr[@id='" + idOfTheTableRow + "']/td[@class='wishlist_delete']/a")).click();
                driver.switchTo().alert().accept();
                break;
            } else {
                driver.findElement(By.cssSelector(".inputTxt.form-control")).sendKeys(productName);
                driver.findElement(By.id("submitWishlist"));
                break;
            }
        }

//        Assertions.assertThat(correctWishList).as("Wishlist not found").isTrue();
//        Assertions.assertThat(wishlist).contains(productName);
    }


}



