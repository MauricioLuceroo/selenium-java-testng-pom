package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SignUpPage extends BasePage {

    private final By firstName = By.cssSelector("input#first_name");
    private final By lastName = By.cssSelector("input[id='last_name']");
    private final By emailAddress = By.cssSelector("input[id='email']");
    private final By password = By.cssSelector("input[id='password']");
    private final By create = By.cssSelector("input[value='Create']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void ingresarNombre(String nombre) {
        WebElement el = waitForVisibility(firstName, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(nombre);
    }

    public void ingresarApellido(String apellido) {
        WebElement el = waitForVisibility(lastName, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(apellido);
    }

    public void ingresarEmail(String email) {
        WebElement el = waitForVisibility(emailAddress, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(email);
    }

    public void ingresarPassword(String pass) {
        WebElement el = waitForVisibility(password, DEFAULT_TIMEOUT_SECONDS);
        el.clear();
        el.sendKeys(pass);
    }

    public void clickCreateAccount() {
        clickWhenVisible(create, DEFAULT_TIMEOUT_SECONDS);
    }

    // Esperar a que la URL ya NO contenga "account/register"
    public void esperarRegistroCompleto() {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("account/register")
        ));
    }

}