package com.itau.teste.br.teste.enumerators;

import java.util.stream.Stream;

public enum NotasEnum {

    NOTA_100(100, 9999, "R$100"),
    NOTA_50(50, 9999, "R$50"),
    NOTA_20(20, 9999, "R$20"),
    NOTA_10(10,9999, "R$10"),
    NOTA_5(5,9999, "R$5"),
    NOTA_2(2,1, "R$2");

    public final int valor;
    public final int qtdeCedulas;
    public final String descricao;

    NotasEnum(int valor, int qtdeCedulas, String descricao) {
        this.valor = valor;
        this.qtdeCedulas = qtdeCedulas;
        this.descricao = descricao;
    }

    public static Stream<NotasEnum> stream() {
        return Stream.of(NotasEnum.values());
    }
}
