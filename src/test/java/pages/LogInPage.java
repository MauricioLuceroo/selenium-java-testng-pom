package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LogInPage extends BasePage {
    private static final String URL_SAUCE_DEMO_LOGIN =
            "https://sauce-demo.myshopify.com/account/login";

    private final By emailAddress = By.cssSelector("input[id='customer_email']");
    private final By passwordField = By.cssSelector("input[id='customer_password']");
    private final By loginButton = By.cssSelector(".action_bottom input[value='Sign In']");


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void abrir() {
        abrirUrl(URL_SAUCE_DEMO_LOGIN);
        waitForVisibility(emailAddress, DEFAULT_TIMEOUT_SECONDS);
    }

    public void escribirUsuario(String usuario) {
        WebElement el = waitForVisibility(emailAddress, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(usuario);
    }

    public void escribirContrasena(String password) {
        WebElement el = waitForVisibility(passwordField, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(password);
    }

    public void clickLogin() {
        clickWhenVisible(loginButton, DEFAULT_TIMEOUT_SECONDS);
    }

    public void login(String usuario, String password) {
        abrir();
        escribirUsuario(usuario);
        escribirContrasena(password);
        clickLogin();
    }
}
