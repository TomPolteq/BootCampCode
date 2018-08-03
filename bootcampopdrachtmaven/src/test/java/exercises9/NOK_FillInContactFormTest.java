package exercises9;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void validationOfEmailField() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.fillInContactForm("Customer service", "nope", "4321234 ", "Help!");
        contactUsPage.messageAfterSending();
        Assertions.assertThat(contactUsPage.messageAfterSending()).as("Sending a messages was successful without a valid email address").contains("Invalid email address.");

    }
}

