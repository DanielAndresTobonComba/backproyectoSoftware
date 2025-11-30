package com.example.backproyecto.Usuario.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.Usuario.application.IUsuario;
import com.example.backproyecto.Usuario.domain.Usuario;

import java.util.Map;


@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "*")
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

    @GetMapping("/{nombre}")
    public ResponseEntity<?> buscarUsuarioPorNombre(@PathVariable String nombre) {
    try {
        Usuario usuario = registroUsuarioService.buscarPorNombre(nombre);
        return ResponseEntity.ok(usuario); // Manda JSON del usuario
    } catch (Exception e) {
        return ResponseEntity.status(404).body("Usuario no encontrado");
    }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datosLogin) {
        try {
            String nombre = datosLogin.get("nombre");
            String contrasena = datosLogin.get("contrasena");

            Usuario usuario = registroUsuarioService.login(nombre, contrasena);

            return ResponseEntity.ok(Map.of(
                "message", "Login exitoso",
                "usuario", usuario
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of(
                "message", "Credenciales incorrectas",
                "error", e.getMessage()
            ));
        }
    }

}
