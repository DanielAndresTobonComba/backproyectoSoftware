package com.example.backproyecto.FacturaAlqueria.application;

import com.example.backproyecto.FacturaAlqueria.domain.FacturaAlqueria;
import com.example.backproyecto.FacturaAlqueria.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaAlqueria.domain.HistorialFacturaResponseDto;

import java.util.List;

public interface IFacturaAlqueriaService {

    FacturaAlqueria crearFactura(FacturaRequestDto request);

    List<HistorialFacturaResponseDto> obtenerFacturasPorNombre(String nombreUsuario);


}
