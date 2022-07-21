package com.example.evalbackend.controller;

import com.example.evalbackend.domain.entities.Cliente;
import com.example.evalbackend.domain.entities.Producto;
import com.example.evalbackend.domain.entities.Venta;
import com.example.evalbackend.services.IServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {

    private final IServicioProducto servicioProducto;

    @Autowired
    public ControladorProducto(IServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }


    @GetMapping
    public ResponseEntity<Page<Producto>> obtenerProductos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<Producto> pageProducts = this.servicioProducto.getAll(pageable);

        if(pageProducts.getTotalElements() > 0) return new ResponseEntity<>(pageProducts, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) throws Exception {
        Optional<Producto> optProducto = this.servicioProducto.getById(id);
        return optProducto
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) throws Exception {
        Producto nuevoProducto = this.servicioProducto.save(producto);
        if(nuevoProducto != null) return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) throws Exception {
        Producto nuevoProducto = this.servicioProducto.save(producto);
        if(nuevoProducto != null) return new ResponseEntity<>(nuevoProducto, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) throws Exception {
        this.servicioProducto.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
