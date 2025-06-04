package com.alunos.projetocadastrodealunos.controllers;

import com.alunos.projetocadastrodealunos.dtos.AlunoDTO;
import com.alunos.projetocadastrodealunos.models.AlunosModels;
import com.alunos.projetocadastrodealunos.repositories.AlunosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunosControllers {

    @Autowired
    private AlunosRepositories alunosRepositories;

    // Criar um novo aluno (Create)
    @PostMapping
    public ResponseEntity<AlunosModels> criarAluno(@RequestBody AlunoDTO dto) {
        AlunosModels novoAluno = new AlunosModels(dto.nome(), dto.email(), dto.idade());
        AlunosModels salvo = alunosRepositories.save(novoAluno);
        return ResponseEntity.ok(salvo);
    }

    // Listar todos os alunos (Read)
    @GetMapping
    public ResponseEntity<List<AlunosModels>> listarAlunos() {
        List<AlunosModels> alunos = alunosRepositories.findAll();
        return ResponseEntity.ok(alunos);
    }

    // Buscar aluno por ID (Read)
    @GetMapping("/{id}")
    public ResponseEntity<AlunosModels> buscarPorId(@PathVariable UUID id) {
        Optional<AlunosModels> aluno = alunosRepositories.findById(id);
        return aluno.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar aluno (Update)
    @PutMapping("/{id}")
    public ResponseEntity<AlunosModels> atualizarAluno(@PathVariable UUID id, @RequestBody AlunoDTO dto) {
        Optional<AlunosModels> optionalAluno = alunosRepositories.findById(id);
        if (optionalAluno.isPresent()) {
            AlunosModels aluno = optionalAluno.get();
            aluno.setNome(dto.nome());
            aluno.setEmail(dto.email());
            aluno.setIdade(dto.idade());
            AlunosModels atualizado = alunosRepositories.save(aluno);
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Deletar aluno (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable UUID id) {
        if (alunosRepositories.existsById(id)) {
            alunosRepositories.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}