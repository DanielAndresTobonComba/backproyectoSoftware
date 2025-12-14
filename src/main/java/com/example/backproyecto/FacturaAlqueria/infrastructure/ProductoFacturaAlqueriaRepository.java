package com.example.backproyecto.FacturaAlqueria.infrastructure;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backproyecto.FacturaAlqueria.domain.HistorialDetalleFacturaDto;
import com.example.backproyecto.FacturaAlqueria.domain.ProductoFacturaAlqueria;
import com.example.backproyecto.FacturaAlqueria.domain.ProductoFacturaId;

import java.util.List;

public interface ProductoFacturaAlqueriaRepository extends JpaRepository<ProductoFacturaAlqueria, ProductoFacturaId> {

@Query(value = """
    SELECT p.nombre,
           pf.cantidad,
           pf.precio_base AS precioUnitario,
           pf.subtotal
    FROM producto_factura_alqueria pf
    JOIN producto_alqueria p
      ON p.id_producto_alqueria = pf.id_producto_alqueria
    WHERE pf.id_factura = :idFactura
""", nativeQuery = true)
List<Object[]> findDetallesByIdFactura(@Param("idFactura") Long idFactura);



    // Convierte los datos en DTOs directamente
    default List<HistorialDetalleFacturaDto> mapDetalles(List<Object[]> data) {
        List<HistorialDetalleFacturaDto> list = new ArrayList<>();
        for (Object[] row : data) {
            HistorialDetalleFacturaDto dto = new HistorialDetalleFacturaDto();
        dto.setProducto((String) row[0]);
        dto.setCantidad((Integer) row[1]);
        dto.setPrecioUnitario(((Number) row[2]).doubleValue());
        dto.setSubtotal(((Number) row[3]).doubleValue());
        list.add(dto);
        }
        return list;
    }
}
