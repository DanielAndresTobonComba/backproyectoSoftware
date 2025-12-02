package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;

public interface ProductoFacturaSurtitiendasRepository
        extends JpaRepository<ProductoSurtitiendas, String> {}
