package com.depositobebidas.depositobebidas.service;

import com.depositobebidas.depositobebidas.model.Bebida;
import com.depositobebidas.depositobebidas.model.Secao;
import com.depositobebidas.depositobebidas.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SecaoService {

    private SecaoRepository  secaoRepository;

    @Autowired
    public SecaoService(SecaoRepository secaoRepository) {
        this.secaoRepository = secaoRepository;
    }

    public List<Secao> consultaSecoesDisponiveisDeArmazenamento(Bebida bebida){
        List<Secao> secoesDisponiveisByBebida = retornaSecoesDisponiveisByBebida(bebida);
        List<Secao> secoesQueContemEspacoParaBebidaSelecionada = new ArrayList<>();
        secoesDisponiveisByBebida.stream().forEach(secao -> {
            if (secao.getCapacidadeArmazenamento() >= bebida.getVolumeTotal()){
                secoesQueContemEspacoParaBebidaSelecionada.add(secao);
            }
        });

        return secoesQueContemEspacoParaBebidaSelecionada;
    }

    private List<Secao> retornaSecoesDisponiveisByBebida(Bebida bebida) {
        List<Secao> secoes = secaoRepository.findAll();
        List<Secao> secoesDisponiveis = new ArrayList<>();
        secoes.stream().forEach(secao -> {
            if(secao.getBebidas().contains(bebida)){
                secoesDisponiveis.add(secao);

            }
        });
        return secoesDisponiveis;
    }
}
