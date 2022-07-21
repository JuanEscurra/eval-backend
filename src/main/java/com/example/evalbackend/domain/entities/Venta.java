package com.example.evalbackend.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "venta", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<DetalleVenta> detallesVenta = new ArrayList<>();

    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        detallesVenta.forEach(dv -> this.addDetalleVenta(dv));
    }

    private void addDetalleVenta(DetalleVenta detalleVenta) {
        detalleVenta.setVenta(this);
        this.detallesVenta.add(detalleVenta);
    }
}
