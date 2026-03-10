package com.foro.hub.domain;

import jakarta.validation.constraints.NotBlank;

public record DTOtopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String fechaCreacion,
        @NotBlank String autor,
        @NotBlank String curso
) {
}
