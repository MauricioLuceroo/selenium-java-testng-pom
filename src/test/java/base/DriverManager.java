package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI,
    }

    public static WebDriver getDriver() {
        return getDriver(BrowserType.CHROME);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            case CHROME:
            default:
                return new ChromeDriver();
        }
    }
}

