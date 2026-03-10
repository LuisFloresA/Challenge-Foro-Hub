package com.foro.hub.domain.topico;

public record DTOListaTopico (
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion

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
