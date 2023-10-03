package com.alura.forum.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        Long id,

        String titulo,

        String mensagem,

        Status status,

        String autor,

        Curso curso
) {
}
