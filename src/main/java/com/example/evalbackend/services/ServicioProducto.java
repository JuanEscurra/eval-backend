package com.example.evalbackend.services;

import com.example.evalbackend.domain.dao.ProductoDao;
import com.example.evalbackend.domain.entities.Producto;
import com.example.evalbackend.services.common.CrudImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioProducto extends CrudImpl<Producto, Long> implements IServicioProducto {

    private final ProductoDao productoDao;

    @Autowired
    public ServicioProducto(ProductoDao productoDAo) {
        this.productoDao = productoDAo;
    }

    @Override
    protected JpaRepository<Producto, Long> getRepository() {
        return this.productoDao;
    }

}
