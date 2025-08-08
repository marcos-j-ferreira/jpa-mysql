 
package com.marcos.jpa.controller;

import com.marcos.jpa.model.Produto;
import com.marcos.jpa.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto criar(@RequestBody @Valid Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody @Valid Produto novoProduto) {
        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(novoProduto.getNome());
                    produto.setPreco(novoProduto.getPreco());
                    return ResponseEntity.ok(repository.save(produto));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }
}

