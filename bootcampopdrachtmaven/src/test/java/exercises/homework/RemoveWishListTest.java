package exercises.homework;

import Pages.*;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RemoveWishListTest extends TestShopScenario {

    @Test
    public void removeAndAddWishList() {

        HomePage homePage = new HomePage(driver);
        WishListPage wishListPage = new WishListPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        String productName = "No Pain No Gain";

        // Go to login page
        homePage.goTologinPage();

        // Login with provide credentials and check if correct user is logged in
        authenticationPage.logIn("tom@huismans.com", "1qazxsw2");
        String welcomeElement = driver.findElement(By.className("account")).getText();
        Assertions.assertThat(welcomeElement).as("user is not logged in").contains("Tom");

        // Open the wishlist page
        myAccountPage.openWishListPage();

        // Checks if the Wishlist exists. If not, it will be created.
        if (!wishListPage.checkExistingOfWishlist(productName)) {
            System.out.println("No wishlist with name, " + productName + " found");
            wishListPage.createNewWishList(productName);
        }

        //  deleting of the wishlist
        wishListPage.removeWishList(productName);

        // Validate that the wishlist is no longer present
        wishListPage.goToProfilePage();
        myAccountPage.openWishListPage();
        wishListPage.checkExistingOfWishlist(productName);
        Assertions.assertThat(wishListPage.checkExistingOfWishlist(productName)).as("Wishlist with name " + productName + " "+ "has not been DELETED successfully").isFalse();
    }
}

//
