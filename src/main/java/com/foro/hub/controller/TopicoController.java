package com.foro.hub.controller;


import com.foro.hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DTOtopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datos);
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
