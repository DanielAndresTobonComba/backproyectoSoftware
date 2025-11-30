package com.example.backproyecto.FacturaAlqueria.domain;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class HistorialFacturaResponseDto {
    private String fecha;
    private String numeroFactura;
    private String cliente;
    private BigDecimal total;
    private List<HistorialDetalleFacturaDto> detalles;
}
