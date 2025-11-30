package com.example.backproyecto.ProductoAlqueria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Producto_alqueria")
public class ProductoAlqueria {

    @Id
    @Column(name = "id_producto_alqueria")
    private String idProductoAlqueria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;


    public ProductoAlqueria() {}

    public ProductoAlqueria(String idProductoAlqueria, String nombre, Double precio) {
        this.idProductoAlqueria = idProductoAlqueria;
        this.nombre = nombre;
        this.precio = precio;
   
    }
}
