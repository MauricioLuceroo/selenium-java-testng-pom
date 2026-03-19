package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
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

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName("Perez");
        checkOutPage.enterAddress("Calle Falsa 123");
        checkOutPage.enterPostcode("12345");
        checkOutPage.enterCity("Buenos Aires");
        checkOutPage.enterCardNumber("4111111111111111");
        checkOutPage.enterExpirationDate("1225");
        checkOutPage.enterSecurityCode("123");
        checkOutPage.enterNameOnCard("Juan Perez");
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("thank_you") || currentUrl.contains("success"),
                "Después del pago, la URL debería indicar éxito. Actual: " + currentUrl);
    }

    @Test(groups = {"regression"})
    public void  compraSinTarjeta() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickHomeButton();
        homePage.clickCartLink();
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName("Perez");
        checkOutPage.enterAddress("Calle Falsa 123");
        checkOutPage.enterPostcode("12345");
        checkOutPage.enterCity("Buenos Aires");
        // No ingresar datos de tarjeta
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("error") || currentUrl.contains("checkout"),
                "Sin tarjeta, debería mostrar error o permanecer en checkout. Actual: " + currentUrl);
    }

    @Test(groups = {"regression"})
    public void  compraTarjetaInvalida() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickHomeButton();
        homePage.clickCartLink();
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName("Perez");
        checkOutPage.enterAddress("Calle Falsa 123");
        checkOutPage.enterPostcode("12345");
        checkOutPage.enterCity("Buenos Aires");
        checkOutPage.enterCardNumber("1234567890123456"); // Tarjeta inválida
        checkOutPage.enterExpirationDate("1225");
        checkOutPage.enterSecurityCode("123");
        checkOutPage.enterNameOnCard("Juan Perez");
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("error") || currentUrl.contains("checkout"),
                "Con tarjeta inválida, debería mostrar error o permanecer en checkout. Actual: " + currentUrl);
    }

    @Test(groups = {"regression"})
    public void  compraConCamposVacios() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickHomeButton();
        homePage.clickCartLink();
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        // No llenar campos
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("error") || currentUrl.contains("checkout"),
                "Con campos vacíos, debería mostrar error o permanecer en checkout. Actual: " + currentUrl);
    }

    @Test(groups = {"regression"})
    public void  compraConCodigoDescuentoValido() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickHomeButton();
        homePage.clickCartLink();
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName("Perez");
        checkOutPage.enterAddress("Calle Falsa 123");
        checkOutPage.enterPostcode("12345");
        checkOutPage.enterCity("Buenos Aires");
        checkOutPage.enterCardNumber("4111111111111111");
        checkOutPage.enterExpirationDate("1225");
        checkOutPage.enterSecurityCode("123");
        checkOutPage.enterNameOnCard("Juan Perez");
        checkOutPage.enterDiscountCode("VALID10"); // Código de descuento válido
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("thank_you") || currentUrl.contains("success"),
                "Con descuento válido, debería procesar la compra. Actual: " + currentUrl);
    }

    @Test(groups = {"regression"})
    public void  compraConCodigoDescuentoInvalida() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickProduct1();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickHomeButton();
        homePage.clickCartLink();
        homePage.clickCheckoutButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButtonCart();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName("Perez");
        checkOutPage.enterAddress("Calle Falsa 123");
        checkOutPage.enterPostcode("12345");
        checkOutPage.enterCity("Buenos Aires");
        checkOutPage.enterCardNumber("4111111111111111");
        checkOutPage.enterExpirationDate("1225");
        checkOutPage.enterSecurityCode("123");
        checkOutPage.enterNameOnCard("Juan Perez");
        checkOutPage.enterDiscountCode("INVALID"); // Código de descuento inválido
        checkOutPage.clickPayNowButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("error") || currentUrl.contains("checkout"),
                "Con descuento inválido, debería mostrar error. Actual: " + currentUrl);
    }
}
