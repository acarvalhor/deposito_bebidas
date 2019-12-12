package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecaoRepository  extends JpaRepository<Secao, Integer> {
}