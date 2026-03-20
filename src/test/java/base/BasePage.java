package base;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    protected static final long DEFAULT_TIMEOUT_SECONDS = 10L;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirUrl(String url) {
        driver.get(url);
    }

    protected WebElement waitForVisibility(By locator, long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void clickWhenVisible(By locator, long timeoutInSeconds) {
        waitForVisibility(locator, timeoutInSeconds).click();
    }

    /**
     * Espera a que todas las peticiones AJAX de jQuery hayan finalizado.
     * Útil tras acciones que disparan llamadas asíncronas (ej: agregar al carrito).
     */
    protected void waitForJQueryAjax(long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until((ExpectedCondition<Boolean>) d ->
                        (Boolean) ((JavascriptExecutor) d)
                                .executeScript(
                                        "return typeof jQuery !== 'undefined' && jQuery.active === 0"));
    }

    public void ingresarEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void ingresarContrasena(String password) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public String tomarCapturaPantalla(String nombreBase) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File origen = ts.getScreenshotAs(OutputType.FILE);

        String marcaDeTiempo = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nombreArchivo = nombreBase + "_" + marcaDeTiempo + ".png";

        File destino = new File("target/screenshots/" + nombreArchivo);
        File carpeta = destino.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }

        try {
            FileHandler.copy(origen, destino);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar la captura de pantalla", e);
        }

        return destino.getAbsolutePath();
    }
}

