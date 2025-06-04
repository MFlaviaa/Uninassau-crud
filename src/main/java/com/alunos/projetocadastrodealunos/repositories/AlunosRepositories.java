package com.alunos.projetocadastrodealunos.repositories;

import com.alunos.projetocadastrodealunos.models.AlunosModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunosRepositories extends JpaRepository<AlunosModels, UUID> {

}
