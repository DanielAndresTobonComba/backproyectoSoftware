package com.example.backproyecto.FacturaSurtitiendas.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductoFacturaDetalleDto {

    private String idProducto;
    private String nombre;
    private String tamano;
    private String imagenUrl;
    private Double precioBase;
    private Integer cantidad;
    private Double subtotal;

    public ProductoFacturaDetalleDto(String idProducto, String nombre, String tamano, String imagenUrl,
                                     Double precioBase, Integer cantidad, Double subtotal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tamano = tamano;
        this.imagenUrl = imagenUrl;
        this.precioBase = precioBase;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // getters y setters
}
