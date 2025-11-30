package com.example.backproyecto.Usuario.application;

import com.example.backproyecto.Usuario.domain.Usuario;

public interface IUsuario {
        Usuario registrarUsuario(Usuario usuario);
        Usuario buscarPorNombre(String nombre);
        Usuario login(String nombre, String contrasena);


}
