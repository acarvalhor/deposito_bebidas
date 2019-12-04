package com.depositobebidas.depositobebidas.model;

public enum TipoBebida {

    ALCOOLICAS("Alcoólicas"),
    NAO_ALCOOLICAS("Não Alcoólicas");

    private String tipoBebida;

    TipoBebida(String tipoBebida){
        this.tipoBebida = tipoBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }
}
