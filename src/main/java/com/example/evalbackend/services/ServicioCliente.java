package com.example.evalbackend.services;

import com.example.evalbackend.domain.dao.ClienteDao;
import com.example.evalbackend.domain.entities.Cliente;
import com.example.evalbackend.services.common.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioCliente extends CrudImpl<Cliente, Long> implements IServicioCliente {

    private final ClienteDao clienteDao;

    @Autowired
    public ServicioCliente(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return this.clienteDao;
    }


}
