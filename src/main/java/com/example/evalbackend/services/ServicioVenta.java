package com.example.evalbackend.services;

import com.example.evalbackend.domain.dao.VentaDao;
import com.example.evalbackend.domain.entities.Venta;
import com.example.evalbackend.services.common.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicioVenta extends CrudImpl<Venta, Long> implements IServicioVenta{

    private final VentaDao ventaDao;

    @Autowired
    public ServicioVenta(VentaDao ventaDao) {
        this.ventaDao = ventaDao;
    }

    @Override
    protected JpaRepository<Venta, Long> getRepository() {
        return this.ventaDao;
    }

    @Override
    public Page<Venta> buscarPorFecha(LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        return this.ventaDao.findByFechaBetween(dateStart, dateEnd, pageable);
    }
}
