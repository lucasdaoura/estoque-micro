package br.com.lucasdaoura.estoquemicro.repository;

import br.com.lucasdaoura.estoquemicro.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
