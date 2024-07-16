package com.alura.challenge.db.model;

import com.alura.challenge.enumeration.EEstado;
import com.alura.challenge.enumeration.EGeneralProperties;
import com.alura.challenge.model.DatoRegistroTema;
import com.alura.challenge.model.DatosTema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "usuarios" )
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "idUsuario" )
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idusuario" )
    private Long idUsuario;

    @Column( unique = true, length = 200 )
    private String nombre;

    @Column( unique = true, length = 100 )
    private String clave;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of( new SimpleGrantedAuthority( "ROLE_USER" ) );
    }

    @Override
    public String getPassword(){
        return this.clave;
    }

    @Override
    public String getUsername(){
        return this.nombre;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
