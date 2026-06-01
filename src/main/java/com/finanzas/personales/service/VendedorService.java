package com.finanzas.personales.service;

import com.finanzas.personales.model.Vendedor;
import com.finanzas.personales.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Vendedor vendedor) {
        repository.save(vendedor);
    }

    public Vendedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
