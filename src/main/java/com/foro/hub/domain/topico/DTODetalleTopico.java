package com.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DTODetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso,
        Boolean status
) {
    public DTODetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus()
        );
    }
}