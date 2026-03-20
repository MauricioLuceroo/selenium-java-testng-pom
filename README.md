# mi-proyecto-testing

Proyecto de automatización de pruebas end-to-end para el sitio [Sauce Demo Shopify](https://sauce-demo.myshopify.com/), desarrollado en el marco del curso de **Selenium Automation** en EducaciónIT.

## Tecnologías utilizadas

| Herramienta | Versión |
|---|---|
| Java | 25 |
| Selenium WebDriver | 4.28.0 |
| TestNG | 7.10.1 |
| Cucumber (BDD) | 7.18.0 |
| Maven | 3.x |

## Estructura del proyecto

```
src/test/java/
├── base/
│   ├── BasePage.java          # Métodos comunes de interacción con la UI
│   ├── BaseTest.java          # Configuración de setup/teardown con TestNG
│   ├── DriverManager.java     # Fábrica de WebDriver (Chrome, Firefox, Edge, Safari)
│   └── ScreenshotListener.java # Captura pantalla automática ante fallos
├── pages/                     # Page Object Model
│   ├── HomePage.java
│   ├── LogInPage.java
│   ├── SignUpPage.java
│   ├── ProductPage.java
│   ├── CartPage.java
│   └── CheckOutPage.java
├── steps/                     # Step definitions de Cucumber
│   ├── Hooks.java
│   └── LoginSteps.java
├── runners/
│   └── CucumberTestRunner.java
└── test/                      # Tests con TestNG
    ├── LoginTest.java
    ├── SignUpTest.java
    ├── BusquedaTest.java
    └── CompraTest.java

src/test/resources/
├── features/                  # Escenarios Cucumber (.feature)
│   ├── login/
│   └── signup/
├── testng-all.xml             # Suite completa
├── testng-smoke.xml           # Suite smoke
└── testng-regression.xml      # Suite de regresión
```

## Cobertura de pruebas

| Módulo | Tipo | Descripción |
|---|---|---|
| Login | TestNG + Cucumber | Acceso con credenciales válidas e inválidas |
| Sign Up | TestNG + Cucumber | Registro de nuevo usuario |
| Búsqueda | TestNG | Búsqueda de productos |
| Compra | TestNG | Flujo completo de compra, sin tarjeta y con tarjeta inválida |

## Requisitos previos

- **JDK 25** o superior instalado y configurado en el `PATH`
- **Maven 3.x** instalado y configurado en el `PATH`
- **Google Chrome** instalado (navegador por defecto)
- Conexión a internet para acceder al sitio bajo prueba

## Cómo ejecutar los tests

### Suite completa

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-all.xml
```

### Suite Smoke

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-smoke.xml
```

### Suite de Regresión

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-regression.xml
```

### Todos los tests con Maven por defecto

```bash
mvn test
```

## Cambiar de navegador

El navegador se configura en `DriverManager.java`. Por defecto se usa **Chrome**. Para usar otro navegador, modificar la llamada a `getDriver()` pasando el tipo deseado:

```java
// Opciones disponibles: CHROME, FIREFOX, EDGE, SAFARI
driver = DriverManager.getDriver(DriverManager.BrowserType.FIREFOX);
```

## Reportes

Los reportes de TestNG se generan automáticamente en la carpeta `test-output/` tras cada ejecución:

- `test-output/emailable-report.html` — Reporte resumido enviable por email
- `test-output/index.html` — Reporte completo interactivo

## Capturas de pantalla

Ante un fallo en cualquier test, `ScreenshotListener` captura automáticamente la pantalla y guarda la imagen en:

```
target/screenshots/
```

## Bugs conocidos

Consultar [KNOWN_BUGS.md](KNOWN_BUGS.md) para ver el registro de bugs conocidos y sus workarounds documentados.

## Patrones utilizados

- **Page Object Model (POM):** cada página del sitio tiene su propia clase en `pages/`, encapsulando sus locators y acciones.
- **BDD con Cucumber:** escenarios escritos en Gherkin en la carpeta `features/`, con sus step definitions en `steps/`.
- **BaseTest / BasePage:** clases base que centralizan la configuración del driver y los métodos de interacción comunes.
