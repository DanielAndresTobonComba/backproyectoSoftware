package com.example.backproyecto.productoSurtitiendas.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.example.backproyecto.productoSurtitiendas.application.IProductoSurtitiendas;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;

import java.util.List;

@Service
public class ProductoSurtitiendasImplement implements IProductoSurtitiendas {

    @Autowired
    private ProductoSurtitiendasRepository productoRepository;

    
    @Override
    public List<ProductoSurtitiendas> obtenerProductos() {
        return productoRepository.findAll();
    }

}
