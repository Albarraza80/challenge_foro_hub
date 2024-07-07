package com.alura.challenge.controller;


import com.alura.challenge.model.DatoRegistroTema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas")
public class ForoController{

    @PostMapping
    public void registarTema(@RequestBody DatoRegistroTema datoRegistroTema ){

        System.out.println("Llegó: " + datoRegistroTema);

    }

}
