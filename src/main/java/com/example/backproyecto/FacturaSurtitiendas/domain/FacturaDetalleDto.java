package com.example.backproyecto.FacturaSurtitiendas.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FacturaDetalleDto {

    private Long idFactura;
    private BigDecimal total;
    private String fecha;
    private List<ProductoFacturaDetalleDto> productos;

    public FacturaDetalleDto(Long idFactura, BigDecimal total, String fecha, List<ProductoFacturaDetalleDto> productos) {
        this.idFactura = idFactura;
        this.total = total;
        this.fecha = fecha;
        this.productos = productos;
    }

    // getters y setters
}