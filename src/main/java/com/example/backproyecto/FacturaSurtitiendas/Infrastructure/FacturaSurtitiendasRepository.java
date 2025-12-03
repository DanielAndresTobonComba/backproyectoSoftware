package com.example.backproyecto.FacturaSurtitiendas.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backproyecto.FacturaSurtitiendas.domain.FacturaSurtitiendas;

import java.util.List;



public interface FacturaSurtitiendasRepository
        extends JpaRepository<FacturaSurtitiendas, Long> {

                List<FacturaSurtitiendas> findByIdUsuario(Long idUsuario);
        }