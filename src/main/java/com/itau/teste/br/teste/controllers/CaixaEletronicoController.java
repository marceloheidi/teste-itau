package com.itau.teste.br.teste.controllers;

import com.itau.teste.br.teste.dto.CaixaEletronicoResponseDto;
import com.itau.teste.br.teste.dto.NotasRetornoDto;
import com.itau.teste.br.teste.service.CaixaEletronicoService;
import com.itau.teste.br.teste.service.impl.CaixaEletronicoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping(path = "/caixa-eletronico")
@RestController
@Api(value="servicos")
public class CaixaEletronicoController {

    private CaixaEletronicoService caixaEletronicoService;

    @Autowired
    public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService) {
        this.caixaEletronicoService = caixaEletronicoService;
    }

    @ApiOperation(value="")
    @GetMapping("/saque/valores/{valor}")
    public ResponseEntity<CaixaEletronicoResponseDto> saqueValor(@PathVariable(name = "valor") Integer valor) {

        return new ResponseEntity<>(caixaEletronicoService.retornaNotas(valor), HttpStatus.OK);
    }
}
