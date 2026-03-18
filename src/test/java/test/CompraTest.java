package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CompraTest extends BaseTest {

    @Test(groups = {"regression"})
    public void compraProducto() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        /* Workaround BUG-001: Volver a home antes de ir al carrito
           Click directo en carrito desde ProductPage  congela la página */

        productPage.clickHomeButton();
        homePage.clickCartLink();
        productPage.tomarCapturaPantalla("compraProducto");
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("checkout") || currentUrl.contains("cart"),
                "Al final del flujo la URL debería ser de checkout o carrito. Actual: " + currentUrl);
    }
}


