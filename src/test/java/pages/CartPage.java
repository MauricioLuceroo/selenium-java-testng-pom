package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By checkoutButtonCart =
            By.xpath("//div[contains(@class,'six') and contains(@class,'columns')]//input[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButtonCart() {
        clickWhenVisible(checkoutButtonCart, DEFAULT_TIMEOUT_SECONDS);
    }
}
