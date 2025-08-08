package com.marcos.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Corrected: Use GenerationType, not GennerationType
    private Long id;

    @NotBlank(message= " O nome não pode estar vazio")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;
    

    @NotNull(message="O preço é obrigatorio")
    @Min(value=1, message= "O preço deve ser no mínimo 1.0")
    private Double preco;
}