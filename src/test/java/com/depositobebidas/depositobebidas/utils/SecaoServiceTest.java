package com.depositobebidas.depositobebidas.utils;

import com.depositobebidas.depositobebidas.repository.SecaoRepository;
import com.depositobebidas.depositobebidas.service.SecaoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SecaoServiceTest {

    @InjectMocks
    SecaoService secaoService;

    @Mock
    SecaoRepository secaoRepository;

    @Before
    public void init(){
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculaVolumeSecao(){

    }

}
