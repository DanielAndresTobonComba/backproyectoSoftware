package com.example.backproyecto.ProductoAlqueria.application;
import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;

import java.util.List;

public interface IProductoAlqueria {
    List<ProductoAlqueria> obtenerProductos(); // Método para obtener todos los productos
}
