package com.itau.teste.br.teste.service.impl;

import com.itau.teste.br.teste.dto.CaixaEletronicoResponseDto;
import com.itau.teste.br.teste.dto.NotasRetornoDto;
import com.itau.teste.br.teste.enumerators.NotasEnum;
import com.itau.teste.br.teste.service.CaixaEletronicoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaixaEletronicoServiceImpl implements CaixaEletronicoService {

    //Serviço que calula a qtde de notas para saque em relação ao valor digitado
    @Override
    public CaixaEletronicoResponseDto retornaNotas(int valorEntrada) {

        List<NotasRetornoDto> notas = new ArrayList<>();

        for (NotasEnum valorNotas : NotasEnum.values()) {
            int qtdeNotas = retornaQtdeNotas(valorEntrada, valorNotas);
            if (qtdeNotas > 0) {
                notas.add(NotasRetornoDto.builder()
                        .valrNota(valorNotas.valor)
                        .qtdeNota(qtdeNotas)
                        .build());
                valorEntrada = valorEntrada - (qtdeNotas * valorNotas.valor);
            }
        }

        return (valorEntrada > 0 || notas.isEmpty()) ?
                CaixaEletronicoResponseDto.builder().mensagem("Não é possível sacar o valor digitado.").build() :
                CaixaEletronicoResponseDto.builder()
                        .mensagem("")
                        .response(notas.stream().map(this::criaDescricao).collect(Collectors.toList()))
                        .build();
    }

    //Metodo que contabiliza a qtde de cédulas à serem entregues baseado na qtde de cédulas disponíveis
    private Integer retornaQtdeNotas(int valorEntrada, NotasEnum notasEnum) {
        return Math.min(Math.max((valorEntrada / notasEnum.valor), 0), notasEnum.qtdeCedulas);
    }

    //Metodo que cria a descricao para o retorno
    private String criaDescricao(NotasRetornoDto notasRetorno) {
        return "Entregar " + notasRetorno.getQtdeNota() + " nota(s) de R$" + notasRetorno.getValrNota() + ".";
    }
}
