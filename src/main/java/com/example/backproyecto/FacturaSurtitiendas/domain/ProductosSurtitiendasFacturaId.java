package com.example.backproyecto.FacturaSurtitiendas.domain;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductosSurtitiendasFacturaId implements Serializable {

    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "id_producto")
    private String idProducto;

    public ProductosSurtitiendasFacturaId() {}

    public ProductosSurtitiendasFacturaId(Long idFactura, String idProducto) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductosSurtitiendasFacturaId)) return false;
        ProductosSurtitiendasFacturaId that = (ProductosSurtitiendasFacturaId) o;
        return Objects.equals(idFactura, that.idFactura)
                && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, idProducto);
    }
}
