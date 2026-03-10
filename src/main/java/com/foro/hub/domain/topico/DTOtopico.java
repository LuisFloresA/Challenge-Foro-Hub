package com.foro.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DTOtopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        LocalDateTime fechaCreacion,
        @NotBlank String autor,
        @NotBlank String curso
) {
}
