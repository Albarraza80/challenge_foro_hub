package com.alura.challenge.model;

import com.alura.challenge.db.model.Usuario;

public record DatosUsuario(

    String nombre,

    String clave,

    Long idUsuario
){
    public DatosUsuario( Usuario usuario){
        this( usuario.getNombre(), usuario.getClave(), usuario.getIdUsuario() );
    }
}
