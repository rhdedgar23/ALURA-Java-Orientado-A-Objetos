package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class MainWithLists {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(8);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.evalua(9);
        var peliculaDeEdgar = new Pelicula("El senior de los anillos", 2001);
        miPelicula.evalua(6);

        Serie casaDragon = new Serie("La casa del dragon", 2022);
        casaDragon.evalua(8);

        // Todas las clases heredan de la superclase Object
        //ArrayList<Titulo> lista = new ArrayList<>();
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeEdgar);
        lista.add(casaDragon);
//        lista.add("Edgar Rodriguez");
//        lista.add(1997);

        for(Titulo item: lista){
            item.imprimeNombreFechaLanzamiento();
            item.imprimeClasificacion();
            System.out.println("");

            if(item instanceof Serie serie && serie.getClasificacion()>2){
                serie.imprimeClasificacion();
            }

            // Cuando se trata de objetos, se pueden copiar los pointers que apuntan hacia el objeto
            // Pelicula cuartaPelicula = miPelicula;
            // El codigo de arriba hace que se cree el objeto cuartaPelicula apuntando hacia la misma direccion
            // de memoria a la cual esta apuntando miPelicula.

        }

    }
}
