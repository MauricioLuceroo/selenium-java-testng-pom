package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.testng.Assert;
import pages.LogInPage;

public class LoginSteps {

    private static final String LOGIN_PATH = "/account/login";
    private LogInPage loginPage;

    @Dado("que estoy en la página de login de Sauce Demo")
    public void que_estoy_en_la_pagina_de_login_de_sauce_demo() {
        loginPage = new LogInPage(Hooks.driver);
        loginPage.abrir();
    }

    @Cuando("ingreso usuario {string} y contraseña {string}")
    public void ingreso_usuario_y_contrasena(String usuario, String password) {
        loginPage.escribirUsuario(usuario);
        loginPage.escribirContrasena(password);
    }

    @Cuando("hago click en el botón de login")
    public void hago_click_en_el_boton_de_login() {
        loginPage.clickLogin();
    }

    @Entonces("el login debería ser exitoso")
    public void el_login_deberia_ser_exitoso() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertFalse(
                currentUrl.contains(LOGIN_PATH),
                "El usuario debería haber salido de login. URL actual: " + currentUrl
        );
    }

    @Entonces("debería permanecer en la página de login")
    public void deberia_permanecer_en_la_pagina_de_login() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains(LOGIN_PATH),
                "El usuario debería seguir en login. URL actual: " + currentUrl
        );
    }
}
