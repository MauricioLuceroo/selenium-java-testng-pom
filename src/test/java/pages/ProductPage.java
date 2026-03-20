package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By addToCartButton =
            By.cssSelector("input#add.btn.add-to-cart");
    private final By homeButton =
            By.cssSelector("#main-menu a[href='/']");
    
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        clickWhenVisible(addToCartButton, DEFAULT_TIMEOUT_SECONDS);
        // Esperar a que el carrito procese la petición AJAX antes de navegar
        waitForJQueryAjax(DEFAULT_TIMEOUT_SECONDS);
    }

    public void clickHomeButton() {
        clickWhenVisible(homeButton, DEFAULT_TIMEOUT_SECONDS);
    }
}
