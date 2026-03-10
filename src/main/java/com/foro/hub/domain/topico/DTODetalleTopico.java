package com.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DTODetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long autor,
        String curso,
        Boolean status
) {
    public DTODetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getId(),
                topico.getCurso(),
                topico.getStatus()
        );
    }
}