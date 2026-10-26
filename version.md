### Uso de LocalStorage

Este sistemas usa `localStorage` para almacenar el token de autenticación del usuario. Esto permite que el usuario 
permanezca logueado incluso después de cerrar la aplicación o recargar la página.

Es una primera solución para manejar la persistencia de la sesión del usuario, pero es importante tener en cuenta que 
localStorage **no es seguro** para almacenar información sensible, como contraseñas o tokens de acceso a servicios externos.

Se hará uso de `localStorage` durante esta primera etapa de desarrollo, pero en futuras versiones se implementarán 
soluciones más seguras, como el uso de cookies con `HttpOnly` y `Secure flags`, o el almacenamiento en el servidor.