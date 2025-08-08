package com.marcos.jpa.repository;

import com.marcos.jpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

// Agora é possível fazer as seguintes operações ao banco de dados.

// produtoRepository.save(novoProduto);
// produtoRepository.findAll();
// produtoRepository.findById(1L);
// produtoRepository.deleteById(1L);

