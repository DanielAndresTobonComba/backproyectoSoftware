package com.example.backproyecto.FacturaAlqueria.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistorialDetalleFacturaDto {
    private String producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
