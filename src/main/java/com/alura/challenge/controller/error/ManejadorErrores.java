package com.alura.challenge.controller.error;

import com.alura.challenge.model.DatosErrorValidacion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorErrores{

    @ExceptionHandler( EntityNotFoundException.class )
    public ResponseEntity errorNoEncontrado(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity errorValidacion(MethodArgumentNotValidException exc){
        var errores = exc.getFieldErrors().stream().map( DatosErrorValidacion::new ).toList();

        return ResponseEntity.badRequest().body( errores );
    }

}


