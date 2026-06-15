package br.com.lucasdaoura.estoquemicro.controller;

import br.com.lucasdaoura.estoquemicro.service.CotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cotacao")
@RequiredArgsConstructor
public class CotacaoController {

    private final CotacaoService cotacaoService;

    @GetMapping("/dolar")
    public ResponseEntity<Map<String, Object>> getCotacaoDolar() {
        return ResponseEntity.ok(cotacaoService.getCotacaoDolar());
    }
}
