package com.example.backproyecto.ProductoAlqueria.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.ProductoAlqueria.application.IProductoAlqueria;
import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productoAlqueria")
@CrossOrigin(origins = "*")
public class ProductoAlqueriaController {

    @Autowired
    private IProductoAlqueria productoAlqueriaService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> obtenerProductos() {
        try {
            List<ProductoAlqueria> productos = productoAlqueriaService.obtenerProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "error al consultar productos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}