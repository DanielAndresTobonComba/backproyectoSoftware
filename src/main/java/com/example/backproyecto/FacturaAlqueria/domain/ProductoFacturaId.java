package com.example.backproyecto.FacturaAlqueria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ProductoFacturaId implements Serializable {

    @Column(name = "idFactura")
    private Long idFactura;

    // columna en la tabla intermedia se llama `idProducto`
    @Column(name = "idProducto")
    private String idProducto;

    public ProductoFacturaId() {}

    public ProductoFacturaId(Long idFactura, String idProducto) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoFacturaId)) return false;
        ProductoFacturaId that = (ProductoFacturaId) o;
        return Objects.equals(idFactura, that.idFactura) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, idProducto);
    }
}