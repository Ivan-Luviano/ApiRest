package com.alura.apirest.service;

import com.alura.apirest.dto.DatosRegistroTopico;
import com.alura.apirest.model.Topico;
import com.alura.apirest.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico crearTopico(DatosRegistroTopico datos) {

        if(repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje");
        }

        Topico topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor(),
                datos.curso()
        );

        return repository.save(topico);
    }

    public List<Topico> listarTopicos(){
        return repository.findAll();
    }

    public Topico obtenerTopico(Long id){
        return repository.findById(id).orElse(null);
    }

    public Topico actualizarTopico(Long id, Topico datos){

        Topico topico = repository.findById(id).orElse(null);

        if(topico != null){
            topico.setTitulo(datos.getTitulo());
            topico.setMensaje(datos.getMensaje());
            topico.setAutor(datos.getAutor());
            topico.setCurso(datos.getCurso());

            return repository.save(topico);
        }

        return null;
    }

    public void eliminarTopico(Long id){
        repository.deleteById(id);
    }
}