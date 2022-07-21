package com.example.evalbackend.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false, unique = true)
    private String dni;

    private String telefono;

    private String email;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Venta> ventas = new ArrayList<>();


}
