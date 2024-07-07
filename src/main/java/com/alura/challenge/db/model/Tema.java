package com.alura.challenge.db.model;

import com.alura.challenge.enumeration.EEstado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "tema" )
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "idTema" )
public class Tema{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idTema" )
    private Long idTema;

    @Column( unique = true, length = 200 )
    private String titulo;

    @Column( unique = true, length = 400 )
    private String mensaje;

    @Column( name = "fecha_creacion" )
    private Date fechaCreacion;

    @Enumerated( EnumType.STRING )
    private EEstado estado;

    private String autor;

    private String curso;
}
