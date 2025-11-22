package com.example.backproyecto.resena.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.resena.domain.resena;


public interface resenaRepository extends JpaRepository<resena, Long> {
}
