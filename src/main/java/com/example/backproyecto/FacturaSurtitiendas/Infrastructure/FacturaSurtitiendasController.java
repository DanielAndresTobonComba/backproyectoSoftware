package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backproyecto.FacturaSurtitiendas.application.IFacturaSurtitiendasService;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaRequestDto;


@RestController
@RequestMapping("/api/facturaSurtitiendas")
@CrossOrigin(origins = "*")
public class FacturaSurtitiendasController {

    @Autowired
    private IFacturaSurtitiendasService service;

    @PostMapping
    public ResponseEntity<?> crearFactura(@RequestBody FacturaRequestDto request) {
        service.crearFactura(request);
        return ResponseEntity.ok(Map.of("mensaje", "Factura creada"));

    }
}