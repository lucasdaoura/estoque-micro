package br.com.lucasdaoura.estoquemicro;

import br.com.lucasdaoura.estoquemicro.service.CotacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CotacaoServiceIntegrationTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CotacaoService cotacaoService;

    @Test
    void deveRetornarCotacaoDolarComCamposEsperados() {
        Map<String, Object> usdbrl = Map.of(
                "bid", "5.75",
                "pctChange", "0.5",
                "create_date", "2026-06-14 10:00:00"
        );
        Map<String, Object> apiResponse = Map.of("USDBRL", usdbrl);

        when(restTemplate.getForObject(any(String.class), eq(Map.class)))
                .thenReturn(apiResponse);

        Map<String, Object> cotacao = cotacaoService.getCotacaoDolar();

        assertThat(cotacao).isNotNull();
        assertThat(cotacao).containsKey("moeda");
        assertThat(cotacao).containsKey("valor");
        assertThat(cotacao.get("moeda")).isEqualTo("USD-BRL");
    }
}
