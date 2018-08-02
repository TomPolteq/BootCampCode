package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class ContactUsPage {

    private final WebDriver driver;

    private By emailTextField = By.cssSelector("input#email");
    private By orderIdTextField = By.cssSelector("input#id_order");
    private By messageTextField = By.cssSelector("textarea#message");
    private By sendButton = By.cssSelector("button#submitMessage");
    private By sendingMessage = By.cssSelector(".alert");
    private By subject = By.id("id_contact");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInContactForm(String subjectSelection, String email, String orderID, String message) {
        Select dropdown = new Select(driver.findElement(subject));
        dropdown.selectByVisibleText(subjectSelection);

        driver.findElement(subject).click();
        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(orderIdTextField).sendKeys(orderID);
        driver.findElement(messageTextField).sendKeys(message);
        driver.findElement(sendButton).click();
        driver.findElement(sendingMessage).isDisplayed();
    }
}