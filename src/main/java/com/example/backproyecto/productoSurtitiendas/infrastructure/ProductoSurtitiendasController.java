package com.example.backproyecto.productoSurtitiendas.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backproyecto.productoSurtitiendas.application.IProductoSurtitiendas;
import com.example.backproyecto.productoSurtitiendas.domain.ProductoSurtitiendas;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productoSurtitiendas")
@CrossOrigin(origins = "*")
public class ProductoSurtitiendasController {

    @Autowired
    private IProductoSurtitiendas productoService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> obtenerProductos() {
        try {
            List<ProductoSurtitiendas> productos = productoService.obtenerProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "error al consultar productos"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
