package com.foro.hub.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topico")
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
    private String fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;

    public Topico(DTOtopico dtoTopico) {
        this.id = null;
        this.titulo = dtoTopico.titulo();
        this.mensaje = dtoTopico.mensaje();
        this.fechaCreacion = dtoTopico.fechaCreacion();
        this.status = true;
        this.autor = dtoTopico.autor();
        this.curso = dtoTopico.curso();
    }
}
