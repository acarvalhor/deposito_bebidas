package com.depositobebidas.depositobebidas.repository;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.Secao;
import com.depositobebidas.depositobebidas.model.TipoBebida;
import com.depositobebidas.depositobebidas.repository.BebidaRepository;
import com.depositobebidas.depositobebidas.utils.Utils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
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
}
