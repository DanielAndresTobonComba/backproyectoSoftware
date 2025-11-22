package com.example.backproyecto.productoSurtitiendas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;

public interface ProductoSurtitiendasRepository extends JpaRepository<ProductoSurtitiendas, String> {
    List<ProductoSurtitiendas> findAll();
}
