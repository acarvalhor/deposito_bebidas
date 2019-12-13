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
import java.util.Optional;

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
        assertThat(secao.getBebidas()).isNotEmpty();
        assertThat(secao.getBebidas().size()).isEqualTo(2);
        assertThat(secao.getCapacidadeArmazenamento()).isEqualTo(500.0);
    }

    @Test
        public void deleteSecaoShoulDeleteData() {
            List<Bebida> bebidas = new ArrayList<>();
            bebidas.add(Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build());
            bebidas.add(Bebida.builder().nome("Fanta").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(300.0).build());
            Secao secao = Secao.builder().capacidadeArmazenamento(500.0).bebidas(bebidas).build();
            this.secaoRepository.save(secao);

            assertThat(secao.getId()).isNotNull();
            assertThat(secao.getBebidas()).isNotEmpty();
            assertThat(secao.getBebidas().size()).isEqualTo(2);
            assertThat(secao.getCapacidadeArmazenamento()).isEqualTo(500.0);

            this.secaoRepository.delete(secao);
            Optional<Secao> secaoFind =  this.secaoRepository.findById(secao.getId());
            assertThat(secaoFind).isEmpty();
    }

    @Test
        public void updateSecaoShoulUpdateData() {
            List<Bebida> bebidas = new ArrayList<>();
            bebidas.add(Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build());
            bebidas.add(Bebida.builder().nome("Fanta").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(300.0).build());
            Secao secao = Secao.builder().capacidadeArmazenamento(500.0).bebidas(bebidas).build();
            this.secaoRepository.save(secao);
            secao.setCapacidadeArmazenamento(300.0);
            this.secaoRepository.save(secao);
            Optional<Secao> secaoFind =  this.secaoRepository.findById(secao.getId());
            assertThat(secaoFind).isNotEmpty();
            assertThat(secaoFind.get().getBebidas().size()).isEqualTo(2);
            assertThat(secaoFind.get().getCapacidadeArmazenamento()).isEqualTo(300.0);
    }

    @Test
    public void findSecaoShoulFindByVolume() {
        List<Bebida> bebidas = new ArrayList<>();
        bebidas.add(Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build());
        bebidas.add(Bebida.builder().nome("Fanta").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(300.0).build());
        Secao secao = Secao.builder().capacidadeArmazenamento(500.0).bebidas(bebidas).build();
        List<Bebida> bebidas2 = new ArrayList<>();
        bebidas.add(Bebida.builder().nome("Vodka").tipoBebida(TipoBebida.ALCOOLICAS).volumeTotal(100.0).build());
        bebidas.add(Bebida.builder().nome("Skol").tipoBebida(TipoBebida.ALCOOLICAS).volumeTotal(200.0).build());
        Secao secao2 = Secao.builder().capacidadeArmazenamento(300.0).bebidas(bebidas2).build();
        this.secaoRepository.save(secao);
        this.secaoRepository.save(secao2);
        List<Secao> secaoFind =  this.secaoRepository.findSecaoByCapacidadeArmazenamento(500.0);
        assertThat(secaoFind).isNotEmpty();
        assertThat(secaoFind.size()).isEqualTo(1);
        assertThat(secaoFind.get(0).getCapacidadeArmazenamento()).isEqualTo(500.0);
    }


}
