package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private final By addToCartButton =
            By.cssSelector("input#add.btn.add-to-cart");
    private final By cartButton =
            By.cssSelector(".toggle-drawer.cart.desktop");
    private final By homeButton =
            By.xpath("//ul[@id='main-menu']//a[contains(text(),'Home')]");
    
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        clickWhenVisible(addToCartButton, DEFAULT_TIMEOUT_SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickHomeButton() {
        clickWhenVisible(homeButton, DEFAULT_TIMEOUT_SECONDS);
    }
}
