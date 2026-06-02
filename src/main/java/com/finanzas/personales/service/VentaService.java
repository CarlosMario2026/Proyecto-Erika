package com.finanzas.personales.service;

import com.finanzas.personales.model.Venta;
import com.finanzas.personales.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Venta venta) {
        repository.save(venta);
    }

    public Venta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
