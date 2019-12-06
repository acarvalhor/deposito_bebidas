package com.depositobebidas.depositobebidas.utils;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.Secao;
import com.depositobebidas.depositobebidas.model.TipoBebida;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static Bebida buildBebida() {
        Bebida bebida = Bebida.builder().nome("Guarana").tipoBebida(TipoBebida.NAO_ALCOOLICAS).volumeTotal(123.3).build();
        bebida.setSecoes(buildSecoes(bebida));
        return bebida;
    }

    private static List<Secao> buildSecoes(Bebida bebida) {
        return Arrays.asList(Secao.builder().capacidadeArmazenamento(400.00).
                bebidas(Arrays.asList(bebida)).build());
    }
}
