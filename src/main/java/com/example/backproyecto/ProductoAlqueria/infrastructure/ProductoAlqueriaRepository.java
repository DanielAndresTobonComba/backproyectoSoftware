package com.example.backproyecto.ProductoAlqueria.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.ProductoAlqueria.domain.ProductoAlqueria;

public interface ProductoAlqueriaRepository extends JpaRepository<ProductoAlqueria, String> {
    // No es necesario definir findAll() ya que JpaRepository lo proporciona
}
