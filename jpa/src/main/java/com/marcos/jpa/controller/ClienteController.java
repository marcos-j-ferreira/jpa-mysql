package com.marcos.jpa.controller;

// importanção da tabela produto, junto com seus métodos
import com.marcos.jpa.model.Cliente;
import com.marcos.jpa.repository.ClienteRepository;

// importações do framework
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;//revisar
import org.springframework.data.domain.Pageable; //revisar

import com.marcos.jpa.model.Cliente;
import com.marcos.jpa.repository.ClienteRepository;
import com.marcos.jpa.service.ClienteService;

@RestController
@RequestMapping("/cliente")

public class ClienteController{

    private final ClienteRepository repository;

    @Autowired //revisar
    private ClienteService clienteService;

    @GetMapping("/listar")
    public final  Page<Cliente> listarCliente(Pageable pageable){
        return clienteService.listarClientes(pageable);
    }

    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente criar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@PathVariable Long id, @RequestBody @Valid Cliente novoCliente){
        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNome(novoCliente.getNome());
                    cliente.setEmail(novoCliente.getEmail());
                    cliente.setTelefone(novoCliente.getTelefone());
                    return ResponseEntity.ok(repository.save(cliente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}






