package com.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DTOListaTopico (
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion

) {
    public DTOListaTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion()
        );
    }
}
