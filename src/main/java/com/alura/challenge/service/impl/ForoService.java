package com.alura.challenge.service.impl;

import com.alura.challenge.db.model.Tema;
import com.alura.challenge.db.repository.TemaRepository;
import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import com.alura.challenge.service.IForoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ForoService implements IForoService{

    private final TemaRepository temaRepository;

    @Autowired
    public ForoService( TemaRepository temaRepository ){
        this.temaRepository = temaRepository;
    }

    @Override
    public DatosTema crearTema( DatoRegistroTema datoRegistroTema ){
        var tema = this.temaRepository.save( new Tema( datoRegistroTema ) );

        return new DatosTema( tema );
    }

    @Override
    @Transactional
    public DatosTema actualizarTema( DatosTema datosTema ){
        Tema tema;

        tema = this.temaRepository.getReferenceById( datosTema.idTema() );

        tema.actualizarTema( datosTema );

        return new DatosTema( tema );
    }

    @Override
    public Page<DatosTema> listarTemas( Pageable pageable ){
        return this.temaRepository.findAll( pageable ).map( DatosTema::new );
    }

    @Override
    public DatosTema muestraUnTema( Long id ){
        Tema tema;

        tema = this.temaRepository.getReferenceById( id );

        return new DatosTema( tema );
    }

    @Override
    public void eliminaUnTema( Long id ){
        Tema tema;

        tema = this.temaRepository.getReferenceById( id );

        this.temaRepository.delete( tema );
    }

}
