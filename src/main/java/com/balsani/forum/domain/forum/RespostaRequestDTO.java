package com.balsani.forum.domain.forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RespostaRequestDTO(@NotBlank String mensagem, @NotNull Long topicoId

) {
}
