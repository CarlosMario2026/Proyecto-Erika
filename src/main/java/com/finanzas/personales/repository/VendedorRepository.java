package com.finanzas.personales.repository;

import com.finanzas.personales.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    List<Vendedor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCaseOrCodigoContainingIgnoreCase(String nombre, String apellido, String codigo);
}