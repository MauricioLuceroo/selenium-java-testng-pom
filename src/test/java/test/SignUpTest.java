package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUpTest extends BaseTest {

    @DataProvider(name = "signUpDataGenerado")
    public Object[][] signUpDataGenerado() {
        int CANTIDAD_FILAS = 2;
        Object[][] datos = new Object[CANTIDAD_FILAS][4];

        // ✅ Formato: 20260314_215630
        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
        );

        for (int i = 1; i <= CANTIDAD_FILAS; i++) {
            datos[i - 1][0] = "Usuario";
            datos[i - 1][1] = "Apellido";
            datos[i - 1][2] = "test_" + timestamp + "_" + i + "@gmail.com";
            datos[i - 1][3] = "Password" + i + "!";
        }

        return datos;
    }
    
    @Test(dataProvider = "signUpDataGenerado", groups = {"regression"})
    public void signUpExitosoConDatosGenerados(String nombre, String apellido, String email, String password) {
        ejecutarRegistro(nombre, apellido, email, password);
    }

    private void ejecutarRegistro(String nombre, String apellido, String email, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.abrir();
        homePage.clickSignUpLink();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.ingresarNombre(nombre);
        signUpPage.ingresarApellido(apellido);
        signUpPage.ingresarEmail(email);
        signUpPage.ingresarPassword(password);
        signUpPage.clickCreateAccount();
        signUpPage.esperarRegistroCompleto();
        signUpPage.tomarCapturaPantalla("signUpExitoso");

        Assert.assertFalse(driver.getCurrentUrl().contains("account/register"),
                "Tras registro exitoso no debería seguir en la página de registro. URL: " + driver.getCurrentUrl());
    }
}
