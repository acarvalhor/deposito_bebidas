package com.depositobebidas.depositobebidas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Bebidas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bebida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome é um campo Obrigatório")
    private String nome;

    @NotNull(message = "Volume é um campo Obrigatório")
    private Double volumeTotal;

    private TipoBebida tipoBebida;

    @ManyToMany
    private List<Secao> secoes;

}
