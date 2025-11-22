package com.example.backproyecto.ProductoAlqueria.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.backproyecto.ProductoAlqueria.application.IProductoAlqueria;
import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoAlqueriaImplement implements IProductoAlqueria {

     @Autowired
    private ProductoAlqueriaRepository productoAlqueriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoAlqueria> obtenerProductos() {
        return productoAlqueriaRepository.findAll(); // Este método debería estar disponible
    }
}
