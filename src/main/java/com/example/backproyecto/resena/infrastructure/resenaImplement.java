package com.example.backproyecto.resena.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.backproyecto.resena.application.Iresena;
import com.example.backproyecto.resena.domain.resena;



@Service
public class resenaImplement implements Iresena {

    @Autowired
    private resenaRepository resenaRepository;

    @Override
    @Transactional
    public resena crearResena(resena resena) {
        // guardar y devolver la entidad guardada; dejar que las excepciones suban para que el controlador las maneje
        return resenaRepository.save(resena);
    }
}
