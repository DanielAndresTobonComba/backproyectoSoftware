package com.example.backproyecto.FacturaSurtitiendas.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;

@Getter
@Setter
@Entity
@Table(name = "Productos_surtitiendas_factura")
public class ProductosSurtitiendasFactura {

    @EmbeddedId
    private ProductosSurtitiendasFacturaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFactura")
    @JoinColumn(name = "id_factura")
    private FacturaSurtitiendas factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private ProductoSurtitiendas producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;   // ← ESTE FALTABA

    public ProductosSurtitiendasFactura() {}
}
