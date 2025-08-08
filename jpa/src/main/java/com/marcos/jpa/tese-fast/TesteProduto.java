
// package com.max.api;

// import com.marcos.jpa.model.Produto;
// import com.marcos.jpa.repository.ProdutoRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class TesteProduto implements CommandLineRunner {

//     private final ProdutoRepository produtoRepository;

//     public TesteProduto(ProdutoRepository produtoRepository) {
//         this.produtoRepository = produtoRepository;
//     }

//     @Override
//     public void run(String... args) {
//         // Criar e salvar um novo produto
//         Produto p1 = new Produto(null, "Monitor", 899.99);
//         produtoRepository.save(p1);

//         // Listar todos os produtos
//         System.out.println("Todos os produtos:");
//         produtoRepository.findAll().forEach(System.out::println);
//     }
// }

