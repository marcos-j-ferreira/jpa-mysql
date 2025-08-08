#!/bin/bash

set -e



# Criar produto
curl -X POST http://localhost:8080/produtos -H Content-Type: application/json -d '{nome: Notebook, preco: 2500.0}'

# Listar todos
curl http://localhost:8080/produtos

# Buscar por ID
curl http://localhost:8080/produtos/1

# Atualizar
curl -X PUT http://localhost:8080/produtos/1 -H Content-Type: application/json -d '{nome: Notebook Gamer, preco: 3000.0}'

# Deletar
curl -X DELETE http://localhost:8080/produtos/1

