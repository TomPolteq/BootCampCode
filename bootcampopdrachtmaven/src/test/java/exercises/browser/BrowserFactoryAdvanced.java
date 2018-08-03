package exercises.browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactoryAdvanced {

    public enum Browser {
        CHROME,
        FIREFOX,
        IE,
        EDGE;
    }

    public static WebDriver getDriver(Browser browser) {
        WebDriver driver;

        switch (browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case IE:
                return createInternetExplorerBrowser();
            case CHROME:
                return createChromeBrowser();
            case EDGE:
                return createEdgeBrowser();
            default:
                return createChromeBrowser();
        }
    }
    private static WebDriver createChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        options.setCapability("chrome.switches", "--verbose");
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeBrowser() {
        EdgeOptions options = new EdgeOptions();
        EdgeDriverManager.getInstance().setup();
        return new EdgeDriver(options);
    }

    private static WebDriver createFireFoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(options);
    }
    private static WebDriver createInternetExplorerBrowser() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver(options);
    }
}
