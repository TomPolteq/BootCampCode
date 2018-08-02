package exercises9;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillContactForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.fillInContactForm("Customer service", "bootcamper@feelthepain.com", "4321234 ", "Ipod defect while lifting, need new one");
        String sendingMessage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertThat(sendingMessage).as("Sending a messages was unsuccessful").contains("Your message has been successfully sent to our team.");
    }
}
