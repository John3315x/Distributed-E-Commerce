CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price NUMERIC(12, 2) NOT NULL,
    category VARCHAR(100) NOT NULL,
    image VARCHAR(500),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT products_price_positive CHECK (price > 0),

    CONSTRAINT products_category_valid CHECK (
        category IN (
            'Computadoras',
            'Perifericos',
            'Monitores',
            'Celulares',
            'Tablets',
            'Audio',
            'Videojuegos',
            'Accesorios',
            'Almacenamiento',
            'Redes',
            'Impresoras',
            'Componentes'
        )
    )
);

INSERT INTO products
(name, description, price, category, image)
VALUES
(
    'Laptop Pro',
    'Laptop de alto rendimiento para trabajo y desarrollo.',
    1299.99,
    'Computadoras',
    'https://images.unsplash.com/photo-1496181133206-80ce9b88a853'
),
(
    'Teclado Mecánico',
    'Teclado mecánico con retroiluminación RGB.',
    79.99,
    'Accesorios',
    'https://images.unsplash.com/photo-1587829741301-dc798b83add3'
),
(
    'Mouse Inalámbrico',
    'Mouse inalámbrico con sensor óptico de alta precisión.',
    39.99,
    'Accesorios',
    'https://images.unsplash.com/photo-1527814050087-3793815479db'
),
(
    'Monitor 27"',
    'Monitor LED de 27 pulgadas con resolución 1440p.',
    299.99,
    'Monitores',
    'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf'
),
(
    'Audífonos',
    'Audífonos over-ear con cancelación de ruido.',
    129.99,
    'Audio',
    'https://images.unsplash.com/photo-1505740420928-5e560c06d30e'
),
(
    'Smartphone',
    'Smartphone de última generación con cámara de alta gama.',
    699.99,
    'Celulares',
    'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9'
);