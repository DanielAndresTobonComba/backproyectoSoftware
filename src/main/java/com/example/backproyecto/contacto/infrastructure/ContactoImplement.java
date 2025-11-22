package com.example.backproyecto.contacto.infrastructure;

import com.example.backproyecto.contacto.application.IContacto;
import com.example.backproyecto.contacto.domain.contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoImplement implements IContacto {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    @Transactional
    public contacto crearContacto(contacto contacto) {
        return contactoRepository.save(contacto);
    }


}
