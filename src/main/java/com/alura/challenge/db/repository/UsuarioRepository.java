package com.alura.challenge.db.repository;

import com.alura.challenge.db.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByNombre( String username);
}
