package com.example.backproyecto.contacto.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.contacto.domain.contacto;

public interface ContactoRepository extends JpaRepository<contacto, Long> {
}