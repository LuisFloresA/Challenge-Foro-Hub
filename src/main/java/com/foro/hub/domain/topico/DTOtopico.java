package com.foro.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOtopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long idUsuario, // Cambiamos el String autor por el ID del usuario
        @NotBlank String curso
) {
}
