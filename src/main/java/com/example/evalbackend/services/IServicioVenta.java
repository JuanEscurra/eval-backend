package com.example.evalbackend.services;

import com.example.evalbackend.domain.entities.Venta;
import com.example.evalbackend.services.common.ICrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IServicioVenta extends ICrud<Venta, Long> {


    Page<Venta> buscarPorFecha(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
}
