package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFactura;
import com.example.backproyecto.FacturaSurtitiendas.domain.ProductosSurtitiendasFacturaId;



public interface ProductosSurtitiendasFacturaRepository
        extends JpaRepository<ProductosSurtitiendasFactura, ProductosSurtitiendasFacturaId> {}