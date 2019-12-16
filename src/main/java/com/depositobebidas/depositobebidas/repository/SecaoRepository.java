package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecaoRepository  extends JpaRepository<Secao, Integer> {

   List<Secao> findSecaoByCapacidadeArmazenamento(Double capacidadeArmazenamento);



}
