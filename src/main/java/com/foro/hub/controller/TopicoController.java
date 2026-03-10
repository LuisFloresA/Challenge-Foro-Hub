package com.foro.hub.controller;


import com.foro.hub.domain.topico.*;
import com.foro.hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DTOtopico datos, UriComponentsBuilder uriComponentsBuilder) {

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Ya existe un tópico con ese mismo título y mensaje.");
        }
        var usuarioBuscado = usuarioRepository.findById(datos.idUsuario());

        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: No se encontró un usuario con el ID proporcionado.");
        }
        var usuario = usuarioBuscado.get();
        var topico = new Topico(datos, usuario);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTODetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<DTOListaTopico>> listar(@PageableDefault(size=10, sort={"titulo"}) Pageable paginacion) {
        var page = repository.findAllByStatusTrue(paginacion).map(DTOListaTopico::new);
        return ResponseEntity.ok(page.getContent());
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DTOEditarTopico datos) {
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DTODetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.eliminar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DTODetalleTopico(topico));
    }

}
