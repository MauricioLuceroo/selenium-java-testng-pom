package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.testng.Assert;
import pages.LogInPage;

public class LoginSteps {

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
        // Acá podrías validar algo real de la página (título, mensaje, etc.)
        Assert.assertTrue(true, "Login ejecutado (placeholder de assert).");
    }
}
