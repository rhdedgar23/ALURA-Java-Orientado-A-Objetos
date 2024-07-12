package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion{
    private String director;

    public Pelicula(String nombre) {
        this.setNombre(nombre);
    }

    // De acuerdo a nuestras reglas de negocio, no hace sentido crear (un objeto del tipo Pelicula) sin nombre
//    public Pelicula() {
//
//    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int)(calculaMedia()/2);
    }
}
