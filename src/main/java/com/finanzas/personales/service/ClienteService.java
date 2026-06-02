package com.finanzas.personales.service;

import com.finanzas.personales.model.Cliente;
import com.finanzas.personales.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> buscar(String texto) {
        return repository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCaseOrDocumentoContainingIgnoreCase(texto, texto, texto);
    }
}
