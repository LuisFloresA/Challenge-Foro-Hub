package com.foro.hub.domain;

public record DTODetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String autor,
        String curso
) {
    public DTODetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
