package com.alura.challenge.controller;

import com.alura.challenge.model.DatosUsuario;
import com.alura.challenge.service.IAutenticacionUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/login" )
public class AutenticacionController{
    private final IAutenticacionUsuario autenticacionUsuario;

    @Autowired
    public AutenticacionController( IAutenticacionUsuario autenticacionUsuario ){
        this.autenticacionUsuario = autenticacionUsuario;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario( @RequestBody @Valid DatosUsuario datosUsuario ){

        return ResponseEntity.ok( this.autenticacionUsuario.autenticarUsuario( datosUsuario ) );
    }

}
