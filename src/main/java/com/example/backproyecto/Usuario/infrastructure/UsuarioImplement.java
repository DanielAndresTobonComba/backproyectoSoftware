package com.example.backproyecto.Usuario.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.backproyecto.Usuario.application.IUsuario;
import com.example.backproyecto.Usuario.domain.Usuario;



@Service
public class UsuarioImplement implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
