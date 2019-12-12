package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.Secao;
import com.depositobebidas.depositobebidas.model.TipoBebida;
import com.depositobebidas.depositobebidas.utils.Utils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BebidaRepositoryTest {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createBebidaShouldPersistData(){
        Bebida bebida = Utils.buildBebida();
        this.bebidaRepository.save(bebida);
        assertThat(bebida.getId()).isNotNull();
        assertThat(bebida.getNome()).isEqualTo("Guarana");
        assertThat(bebida.getTipoBebida()).isEqualTo(TipoBebida.NAO_ALCOOLICAS);
        assertThat(bebida.getVolumeTotal()).isEqualTo(123.3);
        assertThat(bebida.getSecoes()).isNotEmpty();
    }

    @Test
    public void deleteBebidaShouldDeleteData(){
        Bebida bebida = Utils.buildBebida();
        this.bebidaRepository.save(bebida);
        assertThat(bebida.getId()).isNotNull();
        assertThat(bebida.getNome()).isEqualTo("Guarana");
        assertThat(bebida.getTipoBebida()).isEqualTo(TipoBebida.NAO_ALCOOLICAS);
        assertThat(bebida.getVolumeTotal()).isEqualTo(123.3);
        assertThat(bebida.getSecoes()).isNotEmpty();
        this.bebidaRepository.delete(bebida);
        Optional<Bebida> bebidaFind = this.bebidaRepository.findById(bebida.getId());
        assertThat(bebidaFind).isEmpty();
    }

    @Test
    public void updateBebidaChangeAndPersistData(){
        Bebida bebida = Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build();
        Arrays.asList(Secao.builder().capacidadeArmazenamento(400.00).bebidas(Arrays.asList(bebida)).build());
        this.bebidaRepository.save(bebida);
        bebida.setNome("Vodka");
        bebida.setVolumeTotal(555.5);
        this.bebidaRepository.save(bebida);
        Optional<Bebida> optionalBebida = this.bebidaRepository.findById(bebida.getId());
        assertThat(optionalBebida).isNotEmpty();
        assertThat(optionalBebida.get().getId()).isNotNull();
        assertThat(optionalBebida.get().getNome().equals("Vodka"));
        assertThat(optionalBebida.get().getVolumeTotal().equals(555.5));

    }

    @Test
    public void findBebidaByNomeShouldFindByName(){
        Bebida bebida1 = Bebida.builder().nome("Skol").tipoBebida(TipoBebida.ALCOOLICAS).volumeTotal(200.0).build();
        Arrays.asList(Secao.builder().capacidadeArmazenamento(400.00).bebidas(Arrays.asList(bebida1)).build());
        Bebida bebida2 = Bebida.builder().nome("Skol").tipoBebida(TipoBebida.ALCOOLICAS).volumeTotal(250.0).build();
        Arrays.asList(Secao.builder().capacidadeArmazenamento(500.00).bebidas(Arrays.asList(bebida2)).build());
        this.bebidaRepository.save(bebida1);
        this.bebidaRepository.save(bebida2);

        List<Bebida> bebidas = this.bebidaRepository.findBebidaByNome("Skol");
        assertThat(bebidas.size()).isEqualTo(2);

    }

    @Test
    public void createWheNameIsNull(){
       thrown.expect(ConstraintViolationException.class);
        Bebida bebida = new Bebida().builder().volumeTotal(123.123).build();
       this.bebidaRepository.save(bebida);
    }
}
