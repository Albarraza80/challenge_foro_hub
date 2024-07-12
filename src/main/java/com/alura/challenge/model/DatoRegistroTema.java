package com.alura.challenge.model;

import jakarta.validation.constraints.NotBlank;

public record DatoRegistroTema(

    @NotBlank
    String idUsuario,

    @NotBlank
    String mensaje,

    @NotBlank
    String nombreCurso,

    @NotBlank
    String titulo

){}
