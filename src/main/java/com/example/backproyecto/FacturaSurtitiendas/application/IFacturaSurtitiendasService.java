package com.example.backproyecto.FacturaSurtitiendas.application;
import java.util.List;

import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaDetalleDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;

public interface IFacturaSurtitiendasService {

    
    FacturaSurtitiendas crearFactura(FacturaRequestDto request);
    List<FacturaDetalleDto> obtenerFacturasPorNombre(String nombreUsuario);
}
