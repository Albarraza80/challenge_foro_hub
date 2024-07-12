package com.alura.challenge.controller;


import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import com.alura.challenge.service.IForoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/temas" )
public class ForoController{
    private final IForoService foroService;

    @Autowired
    public ForoController( IForoService foroService ){
        this.foroService = foroService;
    }

    @PostMapping
    public void registarTema( @RequestBody @Valid DatoRegistroTema datoRegistroTema ){
        this.foroService.crearTema( datoRegistroTema );
    }

    @GetMapping
    public Page<DatosTema> datosTemaList( @PageableDefault( size = 3 ) Pageable pageable ){
        return this.foroService.listarTemas( pageable );
    }

    @PutMapping( "{id}" )
    public void actualizarTema( @PathVariable Long id, @RequestBody DatosTema datosTema ){
        DatosTema datosTemaAux;

        datosTemaAux = datosTema.setIdTema( id );

        this.foroService.actualizarTema( datosTemaAux );
    }

    @GetMapping( "{id}" )
    public DatosTema muestraUnTema( @PathVariable Long id ){
        return this.foroService.muestraUnTema( id );
    }

    @DeleteMapping( "{id}" )
    public void eliminaUnTema( @PathVariable Long id ){
        this.foroService.eliminaUnTema( id );
    }
}
