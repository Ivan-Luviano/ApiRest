package com.alura.apirest.controller;

import com.alura.apirest.dto.DatosRegistroTopico;
import com.alura.apirest.model.Topico;
import com.alura.apirest.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public Topico crearTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        return service.crearTopico(datos);
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return service.listarTopicos();
    }

    @GetMapping("/{id}")
    public Topico obtenerTopico(@PathVariable Long id) {
        return service.obtenerTopico(id);
    }

    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id, @RequestBody Topico datos) {
        return service.actualizarTopico(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id) {
        service.eliminarTopico(id);
    }
}