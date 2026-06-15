package br.com.lucasdaoura.estoquemicro;

import br.com.lucasdaoura.estoquemicro.service.CotacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CotacaoServiceIntegrationTest {

    @Autowired
    private CotacaoService cotacaoService;

    @Test
    void deveRetornarCotacaoDolarComCamposEsperados() {
        Map<String, Object> cotacao = cotacaoService.getCotacaoDolar();

        assertThat(cotacao).isNotNull();
        assertThat(cotacao).containsKey("moeda");
        assertThat(cotacao).containsKey("valor");
        assertThat(cotacao.get("moeda")).isEqualTo("USD-BRL");
    }
}
