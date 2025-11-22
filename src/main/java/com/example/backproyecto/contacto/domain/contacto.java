package com.example.backproyecto.contacto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private String tipoFacturacion;
    private String comentarios;

    public contacto() {}

    public contacto(String nombre, String apellidos, String correo, String direccion, String telefono, String tipoFacturacion, String comentarios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoFacturacion = tipoFacturacion;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipoFacturacion='" + tipoFacturacion + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }

}
