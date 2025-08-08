package com.marcos.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;


@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message= "O nome não pode estar vazio")
    @Size(min = 3, max = 100, message = "o nome deve ter entre 3 e 100")
    private String nome;

    @NotNull (message = " O email é orbigatorio")
    @Email(message = "invalid email format")
    private String email;

    @NotNull(message = " o telefone deve ser valido")
    @Min(value = 9, message = "Digite um número valido")
    private String telefone; 
}
