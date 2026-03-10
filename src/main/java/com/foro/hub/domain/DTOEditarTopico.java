package com.foro.hub.domain;

import jakarta.validation.constraints.NotNull;

public record DTOEditarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje
) {
}
