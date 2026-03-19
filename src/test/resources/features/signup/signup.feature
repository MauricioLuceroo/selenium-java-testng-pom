Feature: Registro de usuario

  @regression
  Scenario: Registro exitoso con datos dinamicos
    Given que estoy en la página de registro
    When completo el formulario de registro con datos válidos
    And confirmo la creación de cuenta
    Then el registro debería ser exitoso

  @regression
  Scenario: Registro con email ya registrado
    Given que estoy en la página de registro
    When completo el formulario con un email ya registrado
    And confirmo la creación de cuenta
    Then debería permanecer en la página de registro
