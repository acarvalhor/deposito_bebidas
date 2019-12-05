package com.depositobebidas.depositobebidas;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.TipoBebida;
import com.depositobebidas.depositobebidas.repository.BebidaRepository;
import lombok.Builder;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BebidaRepositoryTest {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createBebidaShouldPersistData(){
        Bebida bebida = Bebida.builder().nome("Guarana").
                tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build();
        this.bebidaRepository.save(bebida);
        Assertions.assertThat(bebida.getId()).isNotNull();
        Assertions.assertThat(bebida.getNome()).isEqualTo("Guarana");
        Assertions.assertThat(bebida.getTipoBebida()).isEqualTo(TipoBebida.NAO_ALCOOLICAS);
        Assertions.assertThat(bebida.getVolumeTotal()).isEqualTo(123.3);
    }
}
