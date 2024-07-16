package com.alura.challenge.service;

import com.alura.challenge.model.DatosJwtToken;
import com.alura.challenge.model.DatosUsuario;

public interface IAutenticacionUsuario{

    DatosJwtToken autenticarUsuario( DatosUsuario datosUsuario );

}
