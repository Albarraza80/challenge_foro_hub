package com.alura.challenge.model;

import com.alura.challenge.db.model.Tema;
import com.alura.challenge.enumeration.EGeneralProperties;

import java.text.SimpleDateFormat;

public record DatosTema(

    Long idTema,

    String idUsuario,

    String mensaje,

    String nombreCurso,

    String titulo,

    String estado,

    String fechaCreacion
){
    public DatosTema( Tema tema ){
        this( tema.getIdTema(), tema.getAutor(), tema.getMensaje(), tema.getCurso(), tema.getTitulo(),
            tema.getEstado().toString(),
            ( new SimpleDateFormat( EGeneralProperties.DEFAULT_FORMAT_DATE.getValue() ) ).format(
                tema.getFechaCreacion() ) );
    }

    public DatosTema setIdTema( Long idTema ){
        return new DatosTema( idTema, this.idUsuario, this.mensaje, this.nombreCurso, this.titulo, this.estado,
            this.fechaCreacion );
    }
}
