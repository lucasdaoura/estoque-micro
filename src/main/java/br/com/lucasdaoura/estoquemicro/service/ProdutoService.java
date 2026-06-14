package br.com.lucasdaoura.estoquemicro.service;

import br.com.lucasdaoura.estoquemicro.exception.ProdutoNotFoundException;
import br.com.lucasdaoura.estoquemicro.model.Produto;
import br.com.lucasdaoura.estoquemicro.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com id: " + id));
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Produto existente = buscarPorId(id);
        existente.setNome(produto.getNome());
        existente.setCategoria(produto.getCategoria());
        existente.setQuantidade(produto.getQuantidade());
        existente.setPreco(produto.getPreco());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
