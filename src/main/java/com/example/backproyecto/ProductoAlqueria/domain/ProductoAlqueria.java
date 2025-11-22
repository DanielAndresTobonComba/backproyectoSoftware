package com.example.backproyecto.ProductoAlqueria.domain;

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
    private String idProductoAlqueria; // Asegúrate de que este nombre coincida con el de la base de datos
    private String nombre;
    private Double precio;

    public ProductoAlqueria() {}

    public ProductoAlqueria(String idProductoAlqueria, String nombre, Double precio) {
        this.idProductoAlqueria = idProductoAlqueria;
        this.nombre = nombre;
        this.precio = precio;
    }
}
