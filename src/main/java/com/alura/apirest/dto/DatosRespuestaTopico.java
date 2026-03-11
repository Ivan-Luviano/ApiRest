package com.alura.apirest.dto;

import com.alura.apirest.model.Topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDateTime fechaCreacion

) {

    public DatosRespuestaTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion()
        );
    }

}