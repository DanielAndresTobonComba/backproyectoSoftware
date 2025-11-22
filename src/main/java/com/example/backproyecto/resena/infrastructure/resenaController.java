package com.example.backproyecto.resena.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.resena.application.Iresena;
import com.example.backproyecto.resena.domain.resena;

import java.util.Map;

@RestController
@RequestMapping("/api/resena")
public class resenaController {

    @Autowired
    private Iresena resenaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearResena(@RequestBody resena resena) {
        try {
            resena saved = resenaService.crearResena(resena);
            return new ResponseEntity<>(Map.of("message", "reseña enviado"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "error al enviar reseña"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
