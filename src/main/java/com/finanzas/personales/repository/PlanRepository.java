package com.finanzas.personales.repository;

import com.finanzas.personales.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PlanRepository extends JpaRepository<Plan, Long>{
}
