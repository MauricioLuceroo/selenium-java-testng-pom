package test;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private static final String URL_LOGIN = "https://sauce-demo.myshopify.com/account/login";

    @Test(groups = {"smoke", "regression"})
    public void loginExitoso() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickLoginLink();

        LogInPage loginPage = new LogInPage(driver);
        loginPage.login("JuanLopez@gmail.com", "Prueba1");

        // Espera a que cargue el login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL_LOGIN)));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, URL_LOGIN, "El usuario debería haber iniciado sesión exitosamente.");

    }

    @Test(groups = {"regression"})
    public void loginConUsuarioInvalido() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickLoginLink();

        LogInPage loginPage = new LogInPage(driver);
        loginPage.login("usuario_invalido@example.com", "password_invalida");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, URL_LOGIN, "El usuario no debería haber podido iniciar sesión.");
    }
}
