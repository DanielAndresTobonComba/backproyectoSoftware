package com.example.backproyecto.FacturaAlqueria.infrastructure;

import com.example.backproyecto.FacturaAlqueria.application.IFacturaAlqueriaService;
import com.example.backproyecto.FacturaAlqueria.domain.FacturaAlqueria;
import com.example.backproyecto.FacturaAlqueria.domain.FacturaRequestDto;
import com.example.backproyecto.FacturaAlqueria.domain.HistorialFacturaResponseDto;
import com.example.backproyecto.FacturaAlqueria.domain.ProductoFacturaAlqueria;
import com.example.backproyecto.FacturaAlqueria.domain.ProductoFacturaId;
import com.example.backproyecto.FacturaAlqueria.domain.ProductoItemDto;
import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;
import com.example.backproyecto.ProductoAlqueria.infrastructure.ProductoAlqueriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class FacturaAlqueriaService implements IFacturaAlqueriaService {

    @Autowired
    private FacturaAlqueriaRepository facturaRepo;

    @Autowired
    private ProductoFacturaAlqueriaRepository productoFacturaRepo;

    @Autowired
    private ProductoAlqueriaRepository productoRepo;

    @Override
    @Transactional
    public FacturaAlqueria crearFactura(FacturaRequestDto request) {
        // Crear factura
        FacturaAlqueria factura = new FacturaAlqueria();
        factura.setTotal(request.getTotal());
        Long usuarioId = null;
        if (request.getUsuario() != null && request.getUsuario().get("id") != null) {
            Object idObj = request.getUsuario().get("id");
            if (idObj instanceof Number) usuarioId = ((Number) idObj).longValue();
            else usuarioId = Long.parseLong(idObj.toString());
        }
        factura.setIdUsuario(usuarioId != null ? usuarioId : 0L);
        FacturaAlqueria savedFactura = facturaRepo.save(factura);

        // Guardar productos en Producto_factura_alqueria
        for (ProductoItemDto item : request.getProductos()) {
            Optional<ProductoAlqueria> prodOpt = productoRepo.findById(item.getIdProducto());
            if (prodOpt.isEmpty()) {
                throw new RuntimeException("Producto no encontrado: " + item.getIdProducto());
            }
            ProductoFacturaId pfId = new ProductoFacturaId(savedFactura.getIdFactura(), item.getIdProducto());
            ProductoFacturaAlqueria pf = new ProductoFacturaAlqueria();
            pf.setId(pfId);
            pf.setFactura(savedFactura);
            pf.setProducto(prodOpt.get());
            pf.setCantidad(item.getCantidad());
            pf.setPrecioBase(item.getPrecioUnitario()); // Guardar precio base
            pf.setSubtotal(item.getSubtotal()); // Guardar subtotal
            productoFacturaRepo.save(pf);
        }

        return savedFactura;
    }

    @Transactional(readOnly = true)
    public List<HistorialFacturaResponseDto> obtenerFacturasPorNombre(String nombreUsuario) {

        List<Object[]> facturas = facturaRepo.findFacturasByNombreUsuario(nombreUsuario);  
        List<HistorialFacturaResponseDto> response = new ArrayList<>();

        for (Object[] row : facturas) {

            Long idFactura = ((Number) row[0]).longValue();

            HistorialFacturaResponseDto dto = new HistorialFacturaResponseDto();
            dto.setNumeroFactura("FAC-" + idFactura);
            dto.setTotal((BigDecimal) row[1]);
            dto.setFecha((String) row[2]);
            dto.setCliente((String) row[3]);

            // Detalles
            List<Object[]> detallesData = productoFacturaRepo.findDetallesByIdFactura(idFactura);
            dto.setDetalles(productoFacturaRepo.mapDetalles(detallesData));

            response.add(dto);
        }

        return response;
}


}