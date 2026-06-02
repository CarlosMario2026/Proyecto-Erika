package com.finanzas.personales.service;

import com.finanzas.personales.model.Plan;
import com.finanzas.personales.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository repository;

    public List<Plan> listarTodos() {
        return repository.findAll();
    }

    public Plan buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Plan guardar(Plan plan) {
        return repository.save(plan);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
