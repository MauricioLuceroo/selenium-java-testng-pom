# Bugs Conocidos

Este archivo documenta los bugs conocidos en el proyecto de testing de Selenium.

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

### Bug #1: Contador del carrito no se actualiza inmediatamente
**Descripción:** Después de agregar un producto al carrito, el contador numérico en el icono del carrito no se actualiza inmediatamente.

**Pasos para reproducir:**
1. Ir a la página principal
2. Hacer clic en un producto
3. Agregar al carrito
4. Observar el contador del carrito

**Resultado esperado:** El contador debería mostrar "1" inmediatamente.

**Resultado actual:** El contador no se actualiza hasta recargar la página o navegar.

**Severidad:** Media

**Estado:** Abierto

**Notas adicionales:** Se agregó una espera de 2 segundos en `clickAddToCart()` como workaround temporal.

### Bug #2: Validación de campos en login no muestra mensajes de error
**Descripción:** Cuando se intenta hacer login con campos vacíos o inválidos, no se muestran mensajes de error específicos.

**Pasos para reproducir:**
1. Ir a la página de login
2. Dejar campos vacíos o ingresar datos inválidos
3. Hacer clic en "Sign In"

**Resultado esperado:** Deberían aparecer mensajes de error indicando qué campo es inválido.

**Resultado actual:** La página permanece igual sin feedback visual.

**Severidad:** Alta

**Estado:** Abierto

**Notas adicionales:** Los tests validan que la URL no cambia, pero UX podría mejorarse.

### Bug #3: Screenshot en compraProducto se toma antes de que el carrito se actualice
**Descripción:** La captura de pantalla se toma antes de que el contador del carrito refleje el producto agregado.

**Pasos para reproducir:**
1. Ejecutar el test `compraProducto()`
2. Revisar la screenshot tomada

**Resultado esperado:** La screenshot debería mostrar el carrito con el producto.

**Resultado actual:** Puede que no muestre el contador actualizado.

**Severidad:** Baja

**Estado:** Abierto

**Notas adicionales:** Relacionado con el Bug #1. Se agregó espera de 2 segundos.

---

## Instrucciones para Agregar Nuevos Bugs

1. Copia el formato de arriba
2. Numera el bug consecutivamente
3. Completa todos los campos requeridos
4. Actualiza el estado cuando se resuelva

## Contacto

Reportar nuevos bugs a: [tu-email@ejemplo.com]
