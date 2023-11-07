package com.itau.teste.br.teste.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CaixaEletronicoResponseDto {

    private String mensagem;
    private List<String> response;
}
