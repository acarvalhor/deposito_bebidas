package com.depositobebidas.depositobebidas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Data
@Builder
//@Table(name = "Secao")
@AllArgsConstructor
@NoArgsConstructor
public class Secao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double capacidadeArmazenamento;

    @ManyToOne
    private TipoBebida tipoBebida;
}
