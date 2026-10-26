package com.ecommerce.productservice.entity;

import java.util.Arrays;

public enum Category {
    Computadoras,
    Perifericos,
    Monitores,
    Celulares,
    Tablets,
    Audio,
    Videojuegos,
    Accesorios,
    Almacenamiento,
    Redes,
    Impresoras,
    Componentes;

    // Este metodo permite verificar si un valor dado es un nombre de categoría válido
    public static boolean exists(String value) {
        return Arrays.stream(values())
                .anyMatch(category -> category.name().equalsIgnoreCase(value));
    }
}
