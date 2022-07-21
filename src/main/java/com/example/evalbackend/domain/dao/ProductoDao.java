package com.example.evalbackend.domain.dao;

import com.example.evalbackend.domain.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
}
