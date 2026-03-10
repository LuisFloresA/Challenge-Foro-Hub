package com.foro.hub.domain.topico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"titulo", "mensaje"})
})
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    private Boolean status;
    private String autor;
    private String curso;

    public Topico(DTOtopico dtoTopico) {
        this.titulo = dtoTopico.titulo();
        this.mensaje = dtoTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.autor = dtoTopico.autor();
        this.curso = dtoTopico.curso();
    }

    public void actualizarInformaciones(@Valid DTOEditarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
    }
    public void eliminar() {
        this.status = false;
    }
}
