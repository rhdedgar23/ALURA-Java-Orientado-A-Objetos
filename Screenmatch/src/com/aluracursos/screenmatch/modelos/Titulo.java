package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Clasificacion, Comparable<Titulo>{
    //SerializedName es una anotacion que hace un tipo de conversion entre alguna llave dentro del archivo JSON
    //y nuestra propia variable de clase.
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,2));
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnPlan(boolean incluidoEnPlan) {
        this.incluidoEnPlan = incluidoEnPlan;
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnPlan() {
        return incluidoEnPlan;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Duracion en minutos: " + getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones ++;

    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones/totalDeLasEvaluaciones;
    }

    public void imprimeNombreFechaLanzamiento(){
        System.out.println("Nombre: " + this.nombre
            + "\nFecha de Lanzamiento: " + this.fechaDeLanzamiento
            + "Duracion: " + duracionEnMinutos);
    }

    @Override
    public int getClasificacion() {
        return (int)(calculaMedia()/2);
    }

    public void imprimeClasificacion(){
        System.out.println("Clasificacion: " + this.getClasificacion());
    }

    // Para variables no primitivas, se tiene que Override el metodo compareTo de la clase Coparable<Titulo>
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    public void imprimeTitulo(){
        System.out.println("Titulo: " + this.getNombre());
        System.out.println("Fecha de Lanzamiento: " + this.getFechaDeLanzamiento());
        //System.out.println("Clasificacion: " + this.getClasificacion() );
        System.out.println("Duracion: " + this.duracionEnMinutos);
    }
}
