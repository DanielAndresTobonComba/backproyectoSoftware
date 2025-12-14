package com.example.backproyecto.FacturaSurtitiendas.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "factura_surtitiendas")
public class FacturaSurtitiendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "id", nullable = false)
    private Long idUsuario;

    @Column(length = 16)
    private String fecha;

    public FacturaSurtitiendas() {}
}
