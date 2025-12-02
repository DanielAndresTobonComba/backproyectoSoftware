package com.example.backproyecto.FacturaSurtitiendas.application;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;

public interface IFacturaSurtitiendasService {

    
    FacturaSurtitiendas crearFactura(FacturaRequestDto request);
}
