package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL_SAUCE_DEMO_HOME =
            "https://sauce-demo.myshopify.com/";

    private final By loginLink =
            By.id("customer_login_link");
    private final By product1 =
            By.cssSelector("a[id='product-1']");
    private final By signUpLink =
            By.id("customer_register_link");
    private final By cartLink =
            By.xpath("//div[@id='minicart']//a[contains(text(),'My Cart ')]");
    private final By checkoutButton =
            By.xpath("//div[@class='actions']//input[@value='Check Out']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void abrir() {
        abrirUrl(URL_SAUCE_DEMO_HOME);
    }

    public void clickLoginLink() {
        clickWhenVisible(loginLink, DEFAULT_TIMEOUT_SECONDS);
    }

    public void clickProduct1() {
        clickWhenVisible(product1, DEFAULT_TIMEOUT_SECONDS);
    }

    public void clickSignUpLink() {
        clickWhenVisible(signUpLink, DEFAULT_TIMEOUT_SECONDS);
    }

    public void clickCartLink() {
        clickWhenVisible(cartLink, DEFAULT_TIMEOUT_SECONDS);
    }
    public void clickCheckoutButton() {
        clickWhenVisible(checkoutButton, DEFAULT_TIMEOUT_SECONDS);
    }
}

