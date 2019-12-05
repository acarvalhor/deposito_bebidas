package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida,Integer> {
}
