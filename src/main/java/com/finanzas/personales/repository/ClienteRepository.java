package com.finanzas.personales.repository;

import com.finanzas.personales.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCaseOrDocumentoContainingIgnoreCase(String nombre, String apellido, String documento);
}