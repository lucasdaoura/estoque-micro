package br.com.lucasdaoura.estoquemicro;

import br.com.lucasdaoura.estoquemicro.exception.ProdutoNotFoundException;
import br.com.lucasdaoura.estoquemicro.model.Produto;
import br.com.lucasdaoura.estoquemicro.repository.ProdutoRepository;
import br.com.lucasdaoura.estoquemicro.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    void deveSalvarProdutoComSucesso() {
        Produto produto = Produto.builder()
                .nome("Caneta")
                .categoria("Papelaria")
                .quantidade(10)
                .preco(new BigDecimal("2.50"))
                .build();

        when(repository.save(produto)).thenReturn(produto);

        Produto salvo = service.salvar(produto);

        assertThat(salvo.getNome()).isEqualTo("Caneta");
        verify(repository, times(1)).save(produto);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoEncontrado() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.buscarPorId(99L))
                .isInstanceOf(ProdutoNotFoundException.class)
                .hasMessageContaining("99");
    }

    @Test
    void deveListarTodosProdutos() {
        Produto p1 = Produto.builder().nome("Caneta").categoria("Papelaria").quantidade(5).preco(new BigDecimal("2.00")).build();
        Produto p2 = Produto.builder().nome("Caderno").categoria("Papelaria").quantidade(3).preco(new BigDecimal("15.00")).build();

        when(repository.findAll()).thenReturn(List.of(p1, p2));

        List<Produto> lista = service.listarTodos();

        assertThat(lista).hasSize(2);
    }

    @Test
    void deveDeletarProdutoExistente() {
        Produto produto = Produto.builder().id(1L).nome("Caneta").categoria("Papelaria").quantidade(5).preco(new BigDecimal("2.00")).build();

        when(repository.findById(1L)).thenReturn(Optional.of(produto));

        service.deletar(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
