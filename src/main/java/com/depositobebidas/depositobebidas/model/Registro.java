package com.depositobebidas.depositobebidas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
//
//@Entity
//@Table(name = "Registro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time horarioEntradaSaida;

    @ManyToOne
    private TipoRegistro tipoRegistro;

    private Double volume;

    @ManyToMany
    private Secao secao;

    private String responsavelEntrada;

    @ManyToOne
    private Bebida bebida;
}
