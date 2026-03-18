package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Toma captura de pantalla cuando un test falla.
 * Solo actúa si el test extiende BaseTest (tiene driver).
 */
public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).getDriver();
            if (driver != null) {
                try {
                    BasePage page = new BasePage(driver);
                    String path = page.tomarCapturaPantalla("FAIL_" + result.getName());
                    System.err.println("[ScreenshotListener] Captura guardada: " + path);
                } catch (Exception e) {
                    System.err.println("[ScreenshotListener] No se pudo guardar captura: " + e.getMessage());
                }
            }
        }
    }
}
