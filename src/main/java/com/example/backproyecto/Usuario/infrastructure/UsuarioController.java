package com.example.backproyecto.Usuario.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.Usuario.application.IUsuario;
import com.example.backproyecto.Usuario.domain.Usuario;

import java.util.Map;


@RestController
@RequestMapping("/api/registro")
public class UsuarioController {

     @Autowired
    private IUsuario registroUsuarioService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario saved = registroUsuarioService.registrarUsuario(usuario);
            return new ResponseEntity<>(Map.of("message", "registro exitoso"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "registro fallido"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
