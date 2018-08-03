package exercises.browserDriven;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void fillContactForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.fillInContactForm("Customer service", "bootcamper@feelthepain.com", "4321234 ", "Ipod defect while lifting, need new one");
        contactUsPage.messageAfterSending();
        Assertions.assertThat(contactUsPage.messageAfterSending()).as("Sending a messages was unsuccessful").contains("Your message has been successfully sent to our team.");
    }
}
