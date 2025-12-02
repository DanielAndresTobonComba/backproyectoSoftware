package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;


public interface FacturaSurtitiendasRepository
        extends JpaRepository<FacturaSurtitiendas, Long> {}