package com.alura.challenge.service;

import com.alura.challenge.model.DatosUsuario;

public interface ITokenService{
    String generarToken( DatosUsuario datosUsuario );

    String getSubject(String token);
}
