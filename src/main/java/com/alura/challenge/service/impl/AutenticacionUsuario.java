package com.alura.challenge.service.impl;

import com.alura.challenge.db.model.Usuario;
import com.alura.challenge.model.DatosJwtToken;
import com.alura.challenge.model.DatosUsuario;
import com.alura.challenge.service.IAutenticacionUsuario;
import com.alura.challenge.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionUsuario implements IAutenticacionUsuario{
    private final ITokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AutenticacionUsuario( ITokenService tokenService, AuthenticationManager authenticationManager ){
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public DatosJwtToken autenticarUsuario( DatosUsuario datosUsuario ){
        Authentication authToken;

        authToken = new UsernamePasswordAuthenticationToken( datosUsuario.nombre(), datosUsuario.clave() );

        var usuarioAutenticado = authenticationManager.authenticate( authToken );

        var usuario = ( Usuario ) usuarioAutenticado.getPrincipal();

        var jwtToken = tokenService.generarToken( new DatosUsuario( usuario ) );

        return new DatosJwtToken( jwtToken );
    }
}
