package com.example.backproyecto.FacturaAlqueria.domain;

import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto_factura_alqueria")
public class ProductoFacturaAlqueria {

    @EmbeddedId
    private ProductoFacturaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFactura")
    @JoinColumn(
        name = "id_factura",
        referencedColumnName = "id_factura"
    )
    private FacturaAlqueria factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProducto")
    @JoinColumn(
        name = "id_producto_alqueria",
        referencedColumnName = "id_producto_alqueria"
    )
    private ProductoAlqueria producto;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal;
}
