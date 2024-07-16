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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Column( name = "idtema" )
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

    public Tema( DatoRegistroTema datoRegistroTema ){
        this.autor = datoRegistroTema.idUsuario();
        this.estado = EEstado.ABIERTO;
        this.curso = datoRegistroTema.nombreCurso();
        this.fechaCreacion = new Date();
        this.mensaje = datoRegistroTema.mensaje();
        this.titulo = datoRegistroTema.titulo();
    }

    public void actualizarTema( DatosTema datosTema ){
        SimpleDateFormat format;

        if( datosTema.titulo() != null && !datosTema.titulo().isEmpty() ){
            this.titulo = datosTema.titulo();
        }

        if( datosTema.estado() != null && !datosTema.estado().isEmpty() ){
            this.estado = EEstado.valueOf( datosTema.estado() );
        }

        if( datosTema.nombreCurso() != null && !datosTema.nombreCurso().isEmpty() ){
            this.curso = datosTema.nombreCurso();
        }

        if( datosTema.fechaCreacion() != null && !datosTema.fechaCreacion().isEmpty() ){
            format = new SimpleDateFormat( EGeneralProperties.DEFAULT_FORMAT_DATE.getValue() );

            try{
                this.fechaCreacion = format.parse( datosTema.fechaCreacion() );
            }
            catch( ParseException e ){
                throw new RuntimeException( e );
            }
        }

        if( datosTema.mensaje() != null && !datosTema.mensaje().isEmpty() ){
            this.mensaje = datosTema.mensaje();
        }

    }
}

