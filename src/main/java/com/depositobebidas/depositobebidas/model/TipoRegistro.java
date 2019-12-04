package com.depositobebidas.depositobebidas.model;

public enum TipoRegistro {

    ENTRADA("Entrada"),
    SAIDA("Saida");

    private String tipoRegistro;

    TipoRegistro(String tipoRegistro){
        this.tipoRegistro = tipoRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }
}
