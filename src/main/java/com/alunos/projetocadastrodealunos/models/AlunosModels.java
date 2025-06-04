package com.alunos.projetocadastrodealunos.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Alunos")
public class AlunosModels {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String nome;

    private String email;

    private BigDecimal idade;

    // Construtor padrão
    public AlunosModels() {

        this.id = UUID.randomUUID();

    }

    // Construtor com argumentos (exceto ID)
    public AlunosModels(String nome, String email, BigDecimal idade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    // Construtor com todos os argumentos
    public AlunosModels(UUID id, String nome, String email, BigDecimal idade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getIdade() {
        return idade;
    }

    public void setIdade(BigDecimal idade) {
        this.idade = idade;
    }
}