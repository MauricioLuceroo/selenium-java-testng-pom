Feature: Login en Sauce Demo (Shopify)

  @smoke @regression
  Scenario: Login exitoso con usuario válido
    Given que estoy en la página de login de Sauce Demo
    When ingreso usuario "JuanLopez@gmail.com" y contraseña "Prueba1"
    And hago click en el botón de login
    Then el login debería ser exitoso

  @regression
  Scenario Outline: Login inválido
    Given que estoy en la página de login de Sauce Demo
    When ingreso usuario "<usuario>" y contraseña "<password>"
    And hago click en el botón de login
    Then debería permanecer en la página de login

    Examples:
      | usuario                      | password          |
      | usuario_invalido@example.com | password_invalida |
      |                               | Prueba1           |

