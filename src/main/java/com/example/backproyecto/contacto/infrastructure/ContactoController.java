package com.example.backproyecto.contacto.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.contacto.application.IContacto;
import com.example.backproyecto.contacto.domain.contacto;


import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contacto")
public class ContactoController {

    @Autowired
    private IContacto contactoService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearContacto(@RequestBody contacto contacto) {
        try {
            contacto saved = contactoService.crearContacto(contacto);
            return new ResponseEntity<>(Map.of("message", "contacto enviado"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "error al enviar contacto"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
