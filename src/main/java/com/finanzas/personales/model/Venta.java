package com.finanzas.personales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "Debe seleccionar un cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    @NotNull(message = "Debe seleccionar un vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @NotNull(message = "Debe seleccionar un plan")
    private Plan plan;

    private LocalDate fechaVenta;

    @Enumerated(EnumType.STRING)
    private EstadoVenta estado;

    private String observaciones;

    public enum EstadoVenta {
        PROSPECTO, EN_TRAMITE, APROBADO, RECHAZADO, ACTIVO
    }

    public Venta() {
        this.fechaVenta = LocalDate.now();
        this.estado = EstadoVenta.PROSPECTO;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }
    public LocalDate getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDate fechaVenta) { this.fechaVenta = fechaVenta; }
    public EstadoVenta getEstado() { return estado; }
    public void setEstado(EstadoVenta estado) { this.estado = estado; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
