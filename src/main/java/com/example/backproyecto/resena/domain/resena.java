package com.example.backproyecto.resena.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class resena {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Agregar un ID para la entidad

    private String comentario;
    private String usuario;

    public resena() {}

    public resena(String comentario, String usuario) {
        this.comentario = comentario;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "resena{comentario='" + comentario + "', usuario='" + usuario + "'}";
    }
}