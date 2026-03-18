Feature: Login en Sauce Demo (Shopify)

  Scenario Outline: Login exitoso en Sauce Demo
    Given que estoy en la página de login de Sauce Demo
    When ingreso usuario "<usuario>" y contraseña "<password>"
    And hago click en el botón de login
    Then el login debería ser exitoso

    Examples:
      | usuario | password |
      | admin@example.com   | Password1!   |
      | user@example.com    | Password2!   |

