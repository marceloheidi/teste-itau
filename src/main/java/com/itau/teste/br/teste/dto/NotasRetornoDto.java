package com.itau.teste.br.teste.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotasRetornoDto {

    private int qtdeNota;
    private int valrNota;

}
