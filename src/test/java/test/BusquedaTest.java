package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class BusquedaTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void busquedaProductoBrownShades() {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.enterSearch("Brown Shades");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.toLowerCase().contains("brown") || currentUrl.toLowerCase().contains("search"),
                "La búsqueda debería redirigir a resultados relacionados. URL actual: " + currentUrl);
    }
}
