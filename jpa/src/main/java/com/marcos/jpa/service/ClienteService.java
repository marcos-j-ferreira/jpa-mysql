package com.marcos.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcos.jpa.model.Cliente;
import com.marcos.jpa.repository.ClienteRepository;

//revisar esse modelo

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> listarClientes(Pageable pageable){
        return clienteRepository.findAll(pageable);
    }
}