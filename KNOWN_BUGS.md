# Bugs Conocidos

Este archivo documenta los bugs conocidos en el proyecto de testing con Selenium.

## Formato de Reporte de Bug

### Título del Bug
**Descripción:** Breve descripción del problema.

**Pasos para reproducir:**
1. Paso 1
2. Paso 2
3. Paso 3

**Resultado esperado:** Qué debería suceder.

**Resultado actual:** Qué sucede en realidad.

**Severidad:** (Crítica, Alta, Media, Baja)

**Estado:** (Abierto, En progreso, Resuelto)

**Notas adicionales:**


---

## Bugs Reportados

### Bug #001: BUG-001: Carrito se queda cargando desde página de producto
**Descripción:** Al agregar un producto al carrito desde la página del producto
y luego hacer click en el ícono del carrito, la página se queda cargando
indefinidamente y nunca muestra el contenido del carrito.

**Pasos para reproducir:**
1. Desde el Home, hacer click en un producto para ir a su página deL producto
2. Hacer click en "Add to Cart"
3. Hacer click en el ícono del carrito
4. Observar que la página se queda cargando sin mostrar el contenido del carrito

**Resultado esperado:** Debería mostrar el contenido del carrito con el producto agregado.

**Resultado actual:** La página se queda cargando indefinidamente sin mostrar el contenido del carrito.

**Severidad:** Alta

**Estado:** Abierto

**Notas adicionales:** El problema solo ocurre al hacer click en el carrito directamente desde
la página de producto. Si se vuelve a la página principal primero y luego
se accede al carrito, funciona correctamente.



### Bug #002: Validación de campos en login no muestra mensajes de error
**Descripción:** Cuando se intenta hacer login con campos vacíos o inválidos, no se muestran mensajes de error 
específicos.

**Pasos para reproducir:**
1. Ir a la página de login
2. Dejar campos vacíos o ingresar datos inválidos
3. Hacer clic en "Sign In"

**Resultado esperado:** Deberían aparecer mensajes de error indicando qué campo es inválido.

**Resultado actual:** La página permanece igual sin feedback visual.

**Severidad:** Alta

**Estado:** Abierto

**Notas adicionales:** Los tests validan que la URL no cambia, pero UX podría mejorarse.
