# Tecnologías del Frontend

Estas herramientas forman la base del frontend del proyecto y cada una cumple una función específica. A continuación se explica qué hace cada una y cómo se usan en un proyecto real de e-commerce.

## React
React es la librería principal para construir interfaces de usuario. Permite crear componentes reutilizables, como un botón, un producto, un navbar o un modal, y actualizar solo la parte de la pantalla que cambió.

Ejemplo:
```jsx
function ProductCard({ product }) {
  return (
    <div className="card">
      <h3>{product.name}</h3>
      <p>${product.price}</p>
      <button>Agregar al carrito</button>
    </div>
  );
}
```

Aquí vemos un componente reutilizable: se puede usar muchas veces para mostrar distintos productos sin duplicar código.

## Vite
Vite es la herramienta que ayuda a iniciar el proyecto, ejecutar el servidor de desarrollo y compilar la aplicación para producción. Es muy rápida porque recarga los cambios al instante mientras programamos.

Ejemplo:
- `npm install`
- `npm run dev` → inicia la app localmente
- `npm run build` → genera una versión optimizada para subir a producción

Gracias a Vite, al editar un componente se refleja rápidamente en el navegador sin reiniciar toda la aplicación.

## TypeScript
TypeScript añade tipos a JavaScript, lo que ayuda a evitar errores comunes y a entender mejor el código. En un proyecto con muchos datos, como productos, usuarios y pedidos, los tipos hacen que todo sea más seguro.

Ejemplo:
```ts
type Product = {
  id: number;
  name: string;
  price: number;
  stock: number;
};

const product: Product = {
  id: 1,
  name: 'Camiseta',
  price: 29.99,
  stock: 20,
};
```

Si intentas poner un valor incorrecto, TypeScript te avisa antes de que se ejecute la app.

## JSX
JSX es la sintaxis que permite escribir HTML dentro de JavaScript o TypeScript. En React, se usa para describir la estructura de la interfaz de una forma muy clara.

Ejemplo:
```jsx
const title = 'Bienvenido';

return (
  <section>
    <h1>{title}</h1>
    <p>Compra productos online con facilidad.</p>
  </section>
);
```

JSX mezcla lógica y estructura: puedes generar contenido dinámico con variables y condiciones.

## React Router DOM
React Router DOM permite navegar entre diferentes páginas sin recargar la página completa, como cuando pasas del login a la tienda o del catálogo al detalle de un producto.

Ejemplo:
```jsx
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/products" element={<ProductsPage />} />
      <Route path="/cart" element={<CartPage />} />
    </Routes>
  );
}
```

Esto permite que la app se comporte como una SPA (Single Page Application), con navegación rápida y fluida.

## TailwindCSS
TailwindCSS es un framework que usa clases utilitarias para aplicar estilos directamente en el HTML/JSX. En vez de crear muchos archivos CSS, se usan clases como `bg-blue-500`, `p-4`, `rounded-xl`, `text-white`.

Ejemplo:
```jsx
<button className="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700">
  Comprar ahora
</button>
```

Esto acelera el diseño y mantiene una apariencia consistente en toda la app.

## Shadcn
Shadcn es una colección de componentes UI listos para usar, construidos con buenas prácticas y accesibilidad. Se usa para tener formularios, menús, botones, diálogos y otros elementos con un estilo profesional.

Ejemplo:
- botón de compra
- tarjeta de producto
- modal de confirmación
- formulario de login

En lugar de crear manualmente cada componente, se reutilizan componentes bien diseñados y adaptados al proyecto.

## Lucide
Lucide es una librería de iconos modernos. Se usa para mejorar la comprensión visual de la interfaz: carrito, búsqueda, usuario, corazón, estrella, etc.

Ejemplo:
```jsx
import { ShoppingCart, Search, User } from 'lucide-react';

<button>
  <ShoppingCart />
  Carrito
</button>
```

Con esto la app se ve más clara, profesional y amigable para el usuario.

## Resumen
En conjunto, estas tecnologías permiten crear una aplicación frontend moderna, rápida y mantenible:

- React: crea la interfaz y los componentes.
- Vite: inicia, desarrolla y compila la app.
- TypeScript: detecta errores y agrega seguridad al código.
- JSX: escribe la estructura visual en React.
- React Router DOM: maneja la navegación entre páginas.
- TailwindCSS: diseña la interfaz con clases rápidas y consistentes.
- Shadcn: reutiliza componentes listos para producción.
- Lucide: agrega iconos modernos para mejorar la UX.

En un proyecto de e-commerce, por ejemplo, estas tecnologías permiten construir una tienda con catálogo, carrito, login, detalle de producto y pagos de una manera organizada y escalable.
