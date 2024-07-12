package com.alura.challenge.service;

import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IForoService{
    void crearTema( DatoRegistroTema datoRegistroTema );

    void actualizarTema( DatosTema datosTema );

    Page<DatosTema> listarTemas( Pageable pageable );

    DatosTema muestraUnTema( Long id );

    void eliminaUnTema( Long id );

}