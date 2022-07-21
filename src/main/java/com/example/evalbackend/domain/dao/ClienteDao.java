package com.example.evalbackend.domain.dao;

import com.example.evalbackend.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

}
