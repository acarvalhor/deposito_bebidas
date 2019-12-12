package com.depositobebidas.depositobebidas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "Secao")
@AllArgsConstructor
@NoArgsConstructor
public class Secao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Capacidade de Armazenamento é um campo Obrigatório")
    private Double capacidadeArmazenamento;

    @ManyToMany
    private List<Bebida> bebidas;

}
