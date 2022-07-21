package com.example.evalbackend.controller;


import com.example.evalbackend.domain.entities.Venta;
import com.example.evalbackend.services.IServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class ControladorVentas {

    private final IServicioVenta servicioVenta;

    @Autowired
    private ControladorVentas(IServicioVenta servicioVenta) {
        this.servicioVenta = servicioVenta;
    }

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<Page<Venta>> obtenerVentas(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<Venta> pageVentas = this.servicioVenta.getAll(pageable);

        System.out.println("total de elementos: " + pageVentas.getTotalElements());
        if(pageVentas.getTotalElements() > 0) return new ResponseEntity<>(pageVentas, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) throws Exception {
        Optional<Venta> optVenta = this.servicioVenta.getById(id);

        return optVenta
                .map(venta -> new ResponseEntity<>(venta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping(params = {"dateStart", "dateEnd", "page", "size"})
    public ResponseEntity<Page<Venta>> obtenerVentasPorFechas(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd
            ) {

        System.out.println(dateStart);
        System.out.println(dateEnd);
        Page<Venta> pageVentas = this.servicioVenta.buscarPorFecha(dateStart, dateEnd, PageRequest.of(page, size));

        return new ResponseEntity<>(pageVentas, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Venta> eliminarVenta(@RequestBody Venta venta) throws Exception {
        Venta nuevaVenta = this.servicioVenta.save(venta);
        if(nuevaVenta != null) return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
