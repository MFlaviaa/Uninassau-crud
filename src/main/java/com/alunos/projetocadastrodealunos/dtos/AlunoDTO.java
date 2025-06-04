package com.alunos.projetocadastrodealunos.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record AlunoDTO(
    UUID id,
    String nome,
    String email,
    BigDecimal idade
) {}