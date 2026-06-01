package com.finanzas.personales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "planes")

public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @Positive(message = "El precio debe ser mayor que 0")
    private double precio;

    @Positive(message = "Los gigas deben ser mayores que 0")
    private int gigas;

    @Positive(message = "Los minutos deben ser mayores que 0")
    private int minutos;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    public Plan() {
    }

    public Plan(Long id, String nombre, String tipo, double precio, int gigas, int minutos, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.gigas = gigas;
        this.minutos = minutos;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getGigas() {
        return gigas;
    }

    public void setGigas(int gigas) {
        this.gigas = gigas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

