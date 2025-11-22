package com.example.backproyecto.productoSurtitiendas.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Producto_surtitiendas")
public class ProductoSurtitiendas {

    @Id
    private String idProducto;
    private String nombre;
    private Double precio;
    private String imagenUrl;
    private String tamano;

    public ProductoSurtitiendas() {}

    public ProductoSurtitiendas(String idProducto, String nombre, Double precio, String imagenUrl, String tamano
    ) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.tamano = tamano;
    }


}
