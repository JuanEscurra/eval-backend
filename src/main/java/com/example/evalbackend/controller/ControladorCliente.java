package com.example.evalbackend.controller;

import com.example.evalbackend.domain.entities.Cliente;
import com.example.evalbackend.services.IServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    private final IServicioCliente servicioCliente;

    @Autowired
    public ControladorCliente(IServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> obtenerClientes(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cliente> pageClientes = this.servicioCliente.getAll(pageable);

        if(pageClientes.getTotalElements() > 0) return new ResponseEntity<>(pageClientes, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) throws Exception {
        return new ResponseEntity<>(this.servicioCliente.save(cliente), HttpStatus.CREATED);
    }
}
