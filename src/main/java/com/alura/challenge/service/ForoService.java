package com.alura.challenge.service;

import com.alura.challenge.db.model.Tema;
import com.alura.challenge.db.repository.TemaRepository;
import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForoService implements IForoService{

    private final TemaRepository temaRepository;

    @Autowired
    public ForoService( TemaRepository temaRepository ){
        this.temaRepository = temaRepository;
    }

    @Override
    public void crearTema( DatoRegistroTema datoRegistroTema ){
        this.temaRepository.save( new Tema( datoRegistroTema ) );
    }

    @Override
    @Transactional
    public void actualizarTema( DatosTema datosTema ){
        Optional<Tema> opcionalTema;

        Tema tema;

        opcionalTema = this.temaRepository.findById( datosTema.idTema() );

        if( opcionalTema.isPresent() ){
            tema = opcionalTema.get();

            tema.actualizarTema( datosTema );
        }
    }

    @Override
    public Page<DatosTema> listarTemas( Pageable pageable ){
        return this.temaRepository.findAll( pageable ).map( DatosTema::new );
    }

    @Override
    public DatosTema muestraUnTema( Long id ){
        Optional<Tema> opcionalTema;
        Tema tema;

       opcionalTema =  this.temaRepository.findById( id );

        if( opcionalTema.isPresent() ){
            tema = opcionalTema.get();

            return new DatosTema( tema );
        }

        return null;
    }

    @Override
    public void eliminaUnTema( Long id ){

        Optional<Tema> opcionalTema;
        Tema tema;

        opcionalTema =  this.temaRepository.findById( id );

        if( opcionalTema.isPresent() ){
            tema = opcionalTema.get();
            this.temaRepository.delete( tema );
        }
    }

}
