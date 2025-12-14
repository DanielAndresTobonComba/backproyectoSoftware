package com.example.backproyecto.productoSurtitiendas.domain;

import jakarta.persistence.Column;
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
    @Column(name = "id_producto")
    private String idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "tamano")
    private String tamano;

    public ProductoSurtitiendas() {}

    public ProductoSurtitiendas(
            String idProducto,
            String nombre,
            Double precio,
            String imagenUrl,
            String tamano
    ) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.tamano = tamano;
    }
}
