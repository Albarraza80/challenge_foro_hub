package com.alura.challenge.controller;


import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import com.alura.challenge.service.IForoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping( "/temas" )
public class ForoController{
    private final IForoService foroService;

    @Autowired
    public ForoController( IForoService foroService ){
        this.foroService = foroService;
    }

    @PostMapping
    public ResponseEntity<DatosTema> registarTema( @RequestBody @Valid DatoRegistroTema datoRegistroTema,
                                                   UriComponentsBuilder uriComponentsBuilder ){
        URI url;

        var datosTema = this.foroService.crearTema( datoRegistroTema );

        url = uriComponentsBuilder.path( "/temas/{idTema}" ).buildAndExpand( datosTema.idTema() ).toUri();

        return ResponseEntity.created( url ).body( datosTema );
    }

    @GetMapping
    public ResponseEntity<Page<DatosTema>> datosTemaList( @PageableDefault( size = 3 ) Pageable pageable ){
        return ResponseEntity.ok( this.foroService.listarTemas( pageable ) );
    }

    @PutMapping( "{id}" )
    public ResponseEntity<DatosTema> actualizarTema( @PathVariable Long id, @RequestBody DatosTema datosTema ){
        DatosTema datosTemaAux;

        datosTemaAux = datosTema.setIdTema( id );

        return ResponseEntity.ok( this.foroService.actualizarTema( datosTemaAux ) );
    }

    @GetMapping( "{id}" )
    public ResponseEntity<DatosTema> muestraUnTema( @PathVariable Long id ){
        return ResponseEntity.ok( this.foroService.muestraUnTema( id ) );
    }

    @DeleteMapping( "{id}" )
    public ResponseEntity eliminaUnTema( @PathVariable Long id ){
        this.foroService.eliminaUnTema( id );

        return ResponseEntity.noContent().build();
    }
}
