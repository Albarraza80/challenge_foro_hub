package com.alura.challenge.service.impl;

import com.alura.challenge.db.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AutenticacionService( UsuarioRepository usuarioRepository ){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername( String username )
        throws UsernameNotFoundException{
        return this.usuarioRepository.findByNombre( username );
    }
}
