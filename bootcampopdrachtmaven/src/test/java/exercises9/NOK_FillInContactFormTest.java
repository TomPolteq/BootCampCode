package exercises9;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void invalidSubmitOfForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.fillInContactForm("Customer service", "nope", "4321234 ", "Help!");
        String sendingMessage = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assertions.assertThat(sendingMessage).as("The message is send without a valid email").contains("Invalid email address.");
    }
}

