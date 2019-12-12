package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.Secao;
import com.depositobebidas.depositobebidas.model.TipoBebida;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static  org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SecaoRepositoryTest {

    @Autowired
    SecaoRepository secaoRepository;


    @Test
    public void createSecaoShouldPersist() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build());
        bebidas.add(Bebida.builder().nome("Fanta").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(300.0).build());
        Secao secao = Secao.builder().capacidadeArmazenamento(500.0).bebidas(bebidas).build();
        this.secaoRepository.save(secao);

        assertThat(secao.getId()).isNotNull();
    }
}
