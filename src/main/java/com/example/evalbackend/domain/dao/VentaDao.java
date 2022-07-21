package com.example.evalbackend.domain.dao;


import com.example.evalbackend.domain.entities.Venta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface VentaDao extends JpaRepository<Venta, Long> {


    Page<Venta> findByFechaBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
}
