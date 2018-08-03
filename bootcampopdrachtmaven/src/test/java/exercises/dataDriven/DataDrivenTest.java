package exercises.dataDriven;

import Pages.ContactUsPage;
import Pages.HomePage;
import exercises.chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DataDrivenTest extends TestShopScenario {

    @Parameters ({"subject", "email", "orderID", "message"})
    @Test
    public void fillContactForm(String subject, String email, String orderID, String message) {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        homePage.goToContactPage();
        contactUsPage.fillInContactForm(subject, email, orderID, message);
        contactUsPage.messageAfterSending();
        Assertions.assertThat(contactUsPage.messageAfterSending()).as("Sending a messages was unsuccessful").contains("Your message has been successfully sent to our team.");
    }
}
