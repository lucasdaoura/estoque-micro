package br.com.lucasdaoura.estoquemicro.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CotacaoService {

    private static final String API_URL = "https://economia.awesomeapi.com.br/json/last/USD-BRL";

    private final RestTemplate restTemplate;

    public CotacaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getCotacaoDolar() {
        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
        if (response != null && response.containsKey("USDBRL")) {
            Map<String, Object> usdbrl = (Map<String, Object>) response.get("USDBRL");
            return Map.of(
                "moeda", "USD-BRL",
                "nome", "Dólar Americano/Real Brasileiro",
                "valor", usdbrl.get("bid"),
                "variacao", usdbrl.get("pctChange"),
                "atualizadoEm", usdbrl.get("create_date")
            );
        }
        return Map.of("erro", "Não foi possível obter a cotação");
    }
}
