package com.foro.hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DTOEditarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje
) {
}
