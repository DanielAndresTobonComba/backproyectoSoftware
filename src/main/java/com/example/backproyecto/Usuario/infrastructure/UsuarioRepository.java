package com.example.backproyecto.Usuario.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.Usuario.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
