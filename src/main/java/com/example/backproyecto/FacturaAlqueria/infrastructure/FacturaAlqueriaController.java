package com.example.backproyecto.FacturaAlqueria.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backproyecto.FacturaAlqueria.application.IFacturaAlqueriaService;
import com.example.backproyecto.FacturaAlqueria.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaAlqueria.domain.HistorialFacturaResponseDto;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/facturaAlqueria")
@CrossOrigin(origins = "*")
public class FacturaAlqueriaController {

    @Autowired
    private IFacturaAlqueriaService facturaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> crearFactura(@RequestBody FacturaRequestDto request) {
        try {
            facturaService.crearFactura(request);
            return new ResponseEntity<>(Map.of("message", "factura creada"), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Map.of("message", "error al crear factura"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/historialFacturas/{nombre}")
    public ResponseEntity<?> obtenerFacturasPorNombre(@PathVariable String nombre) {
        try {
            List<HistorialFacturaResponseDto> response = facturaService.obtenerFacturasPorNombre(nombre);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}