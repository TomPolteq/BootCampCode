package exercises9;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    @Test
    public void emailFieldValidation() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.emailFieldValidation("Customer service", "nope");
        Assertions.assertThat(driver.findElement(By.cssSelector(".form-group.form-error")).isDisplayed());
        contactUsPage.emailFieldValidation("Customer service", "nope@correct.com");
        Assertions.assertThat(driver.findElement(By.cssSelector(".form-group.form-ok")).isDisplayed());
    }
}

