package com.example.backproyecto.FacturaAlqueria.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "factura_alqueria")

public class FacturaAlqueria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha", length = 16)  // VARCHAR(16)
    private String fecha;

    public FacturaAlqueria() {}
}
