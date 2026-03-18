package steps;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(); // por defecto CHROME
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

