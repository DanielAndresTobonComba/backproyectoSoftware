package com.example.backproyecto.FacturaAlqueria.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backproyecto.FacturaAlqueria.domain.FacturaAlqueria;
import java.util.List;

public interface FacturaAlqueriaRepository extends JpaRepository<FacturaAlqueria, Long> {

    @Query(value = """
        SELECT f.idFactura, f.total, f.fecha, u.nombre AS cliente
        FROM Factura_alqueria f
        JOIN usuario u ON u.id = f.id_usuario
        WHERE u.nombre = :nombreUsuario
    """, nativeQuery = true)
    List<Object[]> findFacturasByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);
}
