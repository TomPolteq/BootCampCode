package exercises9;

import Pages.ContactUsPage;
import exercises.chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillContactForm (){
        driver.findElement(By.cssSelector("li#header_link_contact > a")).click();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactForm( "Customer service", "bootcamper@feelthepain.com","4321234 ", "Ipod defect while lifting, need new one");

    }
}
