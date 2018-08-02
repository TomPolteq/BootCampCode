package exercises.chapterSix;

import exercises.browser.BrowserFactoryAdvanced;
import exercises.browser.BrowserFactoryBasic;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // Start driver
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);

        // maximize window is no longer needed, this is now done in the browserfactory --> chrome options
       // driver.manage().window().maximize();

        // go to this url
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

